package com.dudumarquess.order_management_api.service;

import com.dudumarquess.order_management_api.dto.OrderDto;
import com.dudumarquess.order_management_api.entity.Order;
import com.dudumarquess.order_management_api.entity.OrderItem;
import com.dudumarquess.order_management_api.entity.OrderStatus;
import com.dudumarquess.order_management_api.entity.Product;
import com.dudumarquess.order_management_api.mapper.OrderMapper;
import com.dudumarquess.order_management_api.repository.OrderRepository;
import com.dudumarquess.order_management_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private ProductService productService;

    public OrderService(OrderRepository orderRepository, ProductService productService, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    public OrderDto createOrder() {
        Order order = new Order();
        order.setCreatedAt(new java.sql.Timestamp(System.currentTimeMillis()));
        order.setStatus(OrderStatus.CREATED);
        order.setTotalPrice(0.0);
        order = orderRepository.save(order);
        return OrderMapper.toDto(order);
    }

    public OrderDto addProductToOrder(Long orderId, Long productId, int quantity) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        if (order.getStatus() != OrderStatus.CREATED) {
            throw new RuntimeException("Order with id: " + orderId + " is not in CREATED status.");
        }

        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0.");
        }
        if (product.getStock() < quantity) {
            throw new RuntimeException("Insufficient stock for product with id: " + productId);
        }

        OrderItem existingItem = order.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(productId))
                .findFirst()
                .orElse(null);

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
        } else {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setUnitPrice(product.getPrice());
            order.addItem(orderItem);
        }

        double total = order.getItems().stream()
                .mapToDouble(item -> item.getUnitPrice() * item.getQuantity())
                .sum();
        order.setTotalPrice(total);
        order = orderRepository.save(order);
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
        return OrderMapper.toDto(order);
    }
}
