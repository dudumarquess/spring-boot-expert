package com.dudumarquess.order_management_api.repository;

import com.dudumarquess.order_management_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public Product findByName(String name);
}
