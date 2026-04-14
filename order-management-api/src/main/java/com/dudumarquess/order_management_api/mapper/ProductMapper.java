package com.dudumarquess.order_management_api.mapper;

import com.dudumarquess.order_management_api.dto.ProductDto;
import com.dudumarquess.order_management_api.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getStock(),
                product.getDescription()
        );
    }
}
