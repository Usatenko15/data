package com.example.data.repository.task1;

import com.example.data.entity.task1.Building;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BuildingRepository extends JpaRepository<Building, Long> {
     Optional<Building> findBuildingByAddress(String address);
     Optional<List<Building>> findBuildingByUserId(Long id);
}