package com.example.data.service.task3;

import com.example.data.entity.task3.Order;
import com.example.data.entity.task3.Task;
import com.example.data.repository.task3.OrderRepository;
import com.example.data.repository.task3.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TaskRepository taskRepository;

//    @Transactional(readOnly = true)
    public Order findById(Long id) {
         return orderRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public Order create(Order order) {
//        Order createdOrder = orderRepository.save(order);
//        createdOrder.getTasks().forEach(task -> markTaskToOrder(task,createdOrder.getOrderId()));
        return orderRepository.save(order);
    }

    @Transactional
    protected void markTaskToOrder(Task task, Long orderId) {
        task.setOrderId(orderId);
        task.getSubTasks().forEach(subtask -> markTaskToOrder(subtask, orderId));
    }
}
