package com.example.data.repository.task3;

import com.example.data.entity.task3.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}