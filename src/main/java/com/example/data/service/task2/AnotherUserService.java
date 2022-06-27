package com.example.data.service.task2;

import com.example.data.entity.task1.Building;
import com.example.data.entity.task1.User;
import com.example.data.entity.task2.AnotherBuilding;
import com.example.data.entity.task2.AnotherUser;
import com.example.data.entity.task2.AnotherUserBuilding;
import com.example.data.repository.task2.AnotherBuildingRepository;
import com.example.data.repository.task2.AnotherUserBuildingRepository;
import com.example.data.repository.task2.AnotherUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnotherUserService {

    @Autowired
    AnotherBuildingRepository anotherBuildingRepository;

    @Autowired
    AnotherUserRepository anotherUserRepository;

    @Autowired
    AnotherUserBuildingRepository anotherUserBuildingRepository;

    public AnotherUser create(AnotherUser user) {
        user = anotherUserRepository.save(user);
        user.getBuildingsAssoc().forEach(anotherUserBuilding ->{
            anotherBuildingRepository.save(anotherUserBuilding.getBuilding());
            anotherUserBuildingRepository.save(anotherUserBuilding);
        });
        return user;
    }

    public AnotherUser findById(Long userId) {
        return anotherUserRepository.findById(userId).orElseThrow(RuntimeException::new);
    }

    public AnotherUser addBuildingByUserId(Long userId, AnotherBuilding building, String time){
        AnotherUser user = findById(userId);
        Optional<AnotherBuilding> buildingFromDB = anotherBuildingRepository.findBuildingByAddress(building.getAddress());
        AnotherUserBuilding anotherUserBuilding;
        if(buildingFromDB.isPresent()){
            anotherUserBuilding = new AnotherUserBuilding (user, buildingFromDB.get(), time);
            anotherUserBuildingRepository.save(anotherUserBuilding);
            user.getBuildingsAssoc().add(anotherUserBuilding);
        }
        else {
            anotherBuildingRepository.save(building);
            anotherUserBuilding = new AnotherUserBuilding (user, building, time);
            anotherUserBuildingRepository.save(anotherUserBuilding);
            user.getBuildingsAssoc().add(anotherUserBuilding);
        }
        return anotherUserRepository.save(user);
    }
}
