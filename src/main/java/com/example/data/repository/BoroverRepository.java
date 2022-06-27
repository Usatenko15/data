package com.example.data.repository;

import com.example.data.entity.task4.Borover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoroverRepository extends JpaRepository<Borover, Long> {
}