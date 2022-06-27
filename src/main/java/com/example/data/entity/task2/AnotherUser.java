package com.example.data.entity.task2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "another_user")
@Getter
@Setter
@ToString(of = {"userId", "name", "buildingsAssoc"})
public class AnotherUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_name")
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<AnotherUserBuilding> buildingsAssoc;
}
