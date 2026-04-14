package com.dudumarquess.order_management_api.service;

import com.dudumarquess.order_management_api.dto.ProductDto;
import com.dudumarquess.order_management_api.entity.Product;
import com.dudumarquess.order_management_api.mapper.ProductMapper;
import com.dudumarquess.order_management_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDto saveProduct(ProductDto product) {
        if (productRepository.findByName(product.getName()) != null) {
            throw new RuntimeException("Product with name " + product.getName() + " already exists.");
        }
        Product entity = new Product();
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setStock(product.getStock());
        entity = productRepository.save(entity);
        return ProductMapper.toDto(entity);
    }
}
