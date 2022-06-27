package com.example.data.service.task3;

import com.example.data.entity.task3.Order;
import com.example.data.entity.task3.Task;
import com.example.data.repository.task3.OrderRepository;
import com.example.data.repository.task3.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    OrderRepository orderRepository;

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Transactional(readOnly = true)
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Transactional
    public void markTaskDone(Long taskId) {
        Task task = findById(taskId);
        task.setDone(true);
        task.getSubTasks().forEach(subtask -> markTaskDone(subtask.getTaskId()));
    }

    @Transactional
    public void deleteById(Long taskId) {
        Task task = findById(taskId);
        Order order = orderRepository.findById(task.getOrderId()).orElseThrow(RuntimeException::new);
        if (order.getTasks().size()==2){
            markTaskDone(order.getTasks().stream().
                    filter(task1 -> task1.getTaskId()!=taskId).findFirst().orElseThrow(RuntimeException::new).getTaskId());
        }
        order.getTasks().remove(task);
//        orderRepository.save(order);
//        taskRepository.deleteById(taskId);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }
}
