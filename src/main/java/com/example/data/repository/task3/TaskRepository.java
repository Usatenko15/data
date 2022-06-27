package com.example.data.repository.task3;

import com.example.data.entity.task3.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOrderId(Long orderId);
}