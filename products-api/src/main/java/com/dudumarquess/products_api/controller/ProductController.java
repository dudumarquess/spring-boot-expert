package com.dudumarquess.products_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dudumarquess.products_api.entity.Product;
import com.dudumarquess.products_api.service.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping() 
    public Product saveProduct(@RequestBody  Product product) {
        System.out.println("Product received: " + product);
        return productService.saveProduct(product);
        
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        if(productId != null) {
            return productService.getProduct(productId);
        }
        System.out.println("The product id is null");
        return null;
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product productUpdated) {
        return productService.updateProduct(productId, productUpdated);
    }

    @GetMapping("/name")
    public List<Product> getProducts(@RequestParam("name") String name) {
        return productService.getProducts(name);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }


    
}
