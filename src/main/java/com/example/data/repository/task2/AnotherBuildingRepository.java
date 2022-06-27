package com.example.data.repository.task2;

import com.example.data.entity.task1.Building;
import com.example.data.entity.task2.AnotherBuilding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface AnotherBuildingRepository extends JpaRepository<AnotherBuilding, Long>, JpaSpecificationExecutor<AnotherBuilding> {
    Optional<AnotherBuilding> findBuildingByAddress(String address);
}