package com.example.data.entity.task3;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TASK")
@Getter
@Setter
@ToString(of = {"taskId", "description", "isDone", "subTasks"})
@EqualsAndHashCode(of = {"taskId", "description"})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", nullable = false)
    private Long taskId;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "is_done", nullable = false)
    private boolean isDone = false;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_task_id")
    private Set<Task> subTasks = new HashSet<>();

    @Column(name = "order_id")
    private Long orderId;
}
