package com.example.data.service.task2;

import com.example.data.entity.task1.Building;
import com.example.data.entity.task2.AnotherBuilding;
import com.example.data.repository.task2.AnotherBuildingRepository;
import com.example.data.repository.task2.AnotherUserBuildingRepository;
import com.example.data.repository.task2.AnotherUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotherBuildingService {

    @Autowired
    AnotherBuildingRepository anotherBuildingRepository;

    @Autowired
    AnotherUserRepository anotherUserRepository;

    @Autowired
    AnotherUserBuildingRepository anotherUserBuildingRepository;

    public void deleteById(Long buildingId) {
        AnotherBuilding building = anotherBuildingRepository.findById(buildingId).orElseThrow(RuntimeException::new);

        building.getUsersAssoc().forEach(anotherUserBuilding -> {
            if (anotherUserBuilding.getUser().getBuildingsAssoc().size()==1){
                anotherUserRepository.delete(anotherUserBuilding.getUser());
            }
        });
        anotherBuildingRepository.deleteById(buildingId);
    }
}
