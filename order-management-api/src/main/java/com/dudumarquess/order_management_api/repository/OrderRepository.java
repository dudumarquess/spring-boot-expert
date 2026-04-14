package com.dudumarquess.order_management_api.repository;

import com.dudumarquess.order_management_api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
