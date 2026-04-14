package com.dudumarquess.order_management_api.controller;

import com.dudumarquess.order_management_api.dto.ProductDto;
import com.dudumarquess.order_management_api.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
        if (productDto == null || productDto.getName() == null || productDto.getPrice() == null || productDto.getStock() == null) {
            return ResponseEntity.badRequest().body("The product must have a name, price and stock.");
        } else if (productDto.getPrice() <= 0 || productDto.getStock() <= 0) {
            return ResponseEntity.badRequest().body("The price and stock must be greater than 0.");
        }

        try {
            ProductDto product = productService.saveProduct(productDto);
            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
