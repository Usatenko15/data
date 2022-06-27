package com.example.data.repository.task2;

import com.example.data.entity.task2.AnotherUser;
import com.example.data.entity.task2.AnotherUserBuilding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotherUserBuildingRepository extends JpaRepository<AnotherUserBuilding, AnotherUser> {
}