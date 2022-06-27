package com.example.data.entity.task3;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "order_tab")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "task_name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private Set<Task> tasks = new HashSet<>();

    public void addTask(Task task) {
        tasks.add(task);
//        if (task.getOrderId() == null) {
//            task.getSubTasks().forEach(subTask -> subTask.setOrderId(this.orderId));
//            tasks.add(task);
//        }
//        else {
//            throw new RuntimeException();
//        }
    }
}
