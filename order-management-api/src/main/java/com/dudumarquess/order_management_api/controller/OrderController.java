package com.dudumarquess.order_management_api.controller;

import com.dudumarquess.order_management_api.dto.OrderDto;
import com.dudumarquess.order_management_api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public OrderDto createOrder() {
        return orderService.createOrder();
    }

    @PostMapping("/{orderId}/products/{productId}")
    public ResponseEntity<?> addProductToOrder(@PathVariable Long orderId, @PathVariable Long productId, @RequestParam int quantity) {
        if (quantity <= 0) {
            return ResponseEntity.badRequest().body("The quantity must be greater than 0.");
        }
        try {
            OrderDto order = orderService.addProductToOrder(orderId, productId, quantity);
            return ResponseEntity.ok().body(order);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
