package com.example.data.service.task1;

import com.example.data.entity.task1.Building;
import com.example.data.repository.task1.BuildingRepository;
import com.example.data.repository.task1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuildingService {
    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    UserRepository userRepository;

    @Transactional
    public Building update(Long buildingId,String updatedAddress) {
        Building updatedBuilding = buildingRepository.findById(buildingId).orElseThrow(RuntimeException::new);
        updatedBuilding.setAddress(updatedAddress);
        return buildingRepository.save(updatedBuilding);
    }

    @Transactional
    public Building create(Building building) {
        return buildingRepository.save(building);
    }

    @Transactional(readOnly = true)
    public Building findByAddress(String address) {
        return buildingRepository.findBuildingByAddress(address).orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly = true)
    public Building findById(Long buildingId) {
        return buildingRepository.findById(buildingId).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void deleteById(Long buildingId) {
        Building building = buildingRepository.findById(buildingId).orElseThrow(RuntimeException::new);
        building.getUsers().forEach(user -> {
            if (user.getBuildings().size()==1){
                user.getBuildings().clear();
            }
            else {
                user.getBuildings().remove(building);
            }
        });
        buildingRepository.deleteById(buildingId);
    }
}
