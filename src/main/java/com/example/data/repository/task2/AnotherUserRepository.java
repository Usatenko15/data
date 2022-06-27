package com.example.data.repository.task2;

import com.example.data.entity.task2.AnotherUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotherUserRepository extends JpaRepository<AnotherUser, Long> {
}