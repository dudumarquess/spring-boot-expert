package com.dudumarquess.order_management_api.mapper;

import com.dudumarquess.order_management_api.dto.OrderDto;
import com.dudumarquess.order_management_api.entity.Order;
import com.dudumarquess.order_management_api.entity.OrderItem;

import java.util.List;

public class OrderMapper {
    public static OrderDto toDto(Order order) {
        List<Long> orderItemIds = order.getItems().stream()
                .map(OrderItem::getId)
                .toList();
        return new OrderDto(
                order.getId(),
                order.getStatus().name(),
                order.getTotalPrice(),
                order.getCreatedAt().toString(),
                orderItemIds
        );
    }
}
