package com.example.data.service.task1;

import com.example.data.entity.task1.Building;
import com.example.data.repository.task1.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlowService {
    @Autowired
    BuildingService buildingService;

    @Autowired
    BuildingRepository buildingRepository;

    @Transactional
    public void deleteById(Long buildingId) {

        Building building = buildingRepository.findById(buildingId).orElseThrow(RuntimeException::new);
        buildingService.deleteById(building.getUserId());
        building.setAddress("ffdsfdsfds");

    }
}
