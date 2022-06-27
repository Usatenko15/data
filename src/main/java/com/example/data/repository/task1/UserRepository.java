package com.example.data.repository.task1;

import com.example.data.entity.task1.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = {"buildings"})
    List<User> findByName(String name);
}