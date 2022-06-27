package com.example.data;

import com.example.data.entity.task3.Order;
import com.example.data.entity.task3.Task;
import com.example.data.repository.task3.OrderRepository;
import com.example.data.repository.task3.TaskRepository;
import com.example.data.service.task3.OrderService;
import com.example.data.service.task3.TaskService;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Task3Tests {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    TaskService taskService;

    @Autowired
    TaskRepository taskRepository;

    @BeforeEach
    void setUp() {

        taskRepository.deleteAll();
        orderRepository.deleteAll();
    }

    @Test
    void markTaskAsDone() {
        Task task = new Task();
        task.setDescription("222fdsf");
        Task sub1 = new Task();
        Task sub2 = new Task();
        sub1.setDescription("fdsfds1");
        sub2.setDescription("fdsfds2");
        Set<Task> subtasks = new HashSet<>();
        subtasks.add(sub1);
        subtasks.add(sub2);
        task.setSubTasks(subtasks);
        Task sub3 = new Task();
        sub3.setDescription("fdsfds3");
        Task sub4 = new Task();
        sub4.setDescription("fdsfds4");
        Set<Task> subtasks1 = new HashSet<>();
        subtasks1.add(sub3);
        subtasks1.add(sub4);
        sub1.setSubTasks(subtasks1);
        Task sub5 = new Task();
        sub5.setDescription("fdsfds5");
        Task sub6 = new Task();
        sub6.setDescription("fdsfds6");
        Set<Task> subtasks2 = new HashSet<>();
        subtasks2.add(sub5);
        subtasks2.add(sub6);
        sub2.setSubTasks(subtasks2);
        task.setSubTasks(subtasks);

        Long taskId = taskService.create(task).getTaskId();
        taskService.markTaskDone(taskId);
        taskService.findAll().forEach(task1 -> assertTrue(task1.isDone()));
    }

    @Test
    void createOrderWithTasks() {

        Task task = new Task();
        task.setDescription("222fdsf");
        Task sub1 = new Task();
        Task sub2 = new Task();
        sub1.setDescription("fdsfds1");
        sub2.setDescription("fdsfds2");
        Set<Task> subtasks = new HashSet<>();
        subtasks.add(sub1);
        subtasks.add(sub2);
        task.setSubTasks(subtasks);
        Task sub3 = new Task();
        sub3.setDescription("fdsfds3");
        Task sub4 = new Task();
        sub4.setDescription("fdsfds4");
        Set<Task> subtasks1 = new HashSet<>();
        subtasks1.add(sub3);
        subtasks1.add(sub4);
        sub1.setSubTasks(subtasks1);
        Task sub5 = new Task();
        sub5.setDescription("fdsfds5");
        Task sub6 = new Task();
        sub6.setDescription("fdsfds6");
        Set<Task> subtasks2 = new HashSet<>();
        subtasks2.add(sub5);
        subtasks2.add(sub6);
        sub2.setSubTasks(subtasks2);
        task.setSubTasks(subtasks);

        Order order = new Order();
        order.setName("order2");
        order.addTask(task);
        Long orderId = orderService.create(order).getOrderId();
        taskService.findAll().forEach(task1 -> assertEquals(task1.getOrderId(), orderId));
    }

    @Test
    void deleteTaskById() {

        Task task = new Task();
        task.setDescription("222fdsf");
        Task sub1 = new Task();
        Task sub2 = new Task();
        sub1.setDescription("fdsfds1");
        sub2.setDescription("fdsfds2");
        Set<Task> subtasks = new HashSet<>();
        subtasks.add(sub1);
        subtasks.add(sub2);
        task.setSubTasks(subtasks);
        Task sub3 = new Task();
        sub3.setDescription("fdsfds3");
        Task sub4 = new Task();
        sub4.setDescription("fdsfds4");
        Set<Task> subtasks1 = new HashSet<>();
        subtasks1.add(sub3);
        subtasks1.add(sub4);
        sub1.setSubTasks(subtasks1);
        Task sub5 = new Task();
        sub5.setDescription("fdsfds5");
        Task sub6 = new Task();
        sub6.setDescription("fdsfds6");
        Set<Task> subtasks2 = new HashSet<>();
        subtasks2.add(sub5);
        subtasks2.add(sub6);
        sub2.setSubTasks(subtasks2);
        task.setSubTasks(subtasks);


        Task task12 = new Task();
        task12.setDescription("222fdsf");
        Task sub13 = new Task();
        Task sub14 = new Task();
        sub13.setDescription("fdsfds1");
        sub14.setDescription("fdsfds2");
        Set<Task> subtasks12 = new HashSet<>();
        subtasks12.add(sub13);
        subtasks12.add(sub14);
        task12.setSubTasks(subtasks12);


        Order order = new Order();
        order.setName("sddsggg");
        order.addTask(task);
        order.addTask(task12);
//        Order pfdsf = orderService.create(order);
        orderService.create(order);
//        taskRepository.deleteById(192l);
//        order.setOrderId(1l);

//        Order pfdsf = orderService.create(order);
//
//        System.out.println(task.getTaskId());
        taskService.deleteById(task.getTaskId());
    }
}
