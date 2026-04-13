package com.dudumarquess.products_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dudumarquess.products_api.entity.Product;
import com.dudumarquess.products_api.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);    
    }
    

    public Product getProduct(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    public Product updateProduct(Long productId, Product newProduct) {
        Product product = productRepository.findById(productId).orElse(null);
        if(product != null) {
            product.setName(newProduct.getName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return productRepository.save(product);
        }
        return null;
    }


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProducts(String name) {
        return productRepository.findByName(name);
    }
}
