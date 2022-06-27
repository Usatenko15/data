package com.example.data.service.task1;

import com.example.data.entity.task1.Building;
import com.example.data.entity.task1.User;
import com.example.data.repository.task1.BuildingRepository;
import com.example.data.repository.task1.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildingRepository buildingRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User addBuildingByUserId(Long userId, Building building){
        buildingRepository.findById(126l);
        User user = userRepository.findById(userId).orElseThrow();
        Optional<Building> buildingFromDB = buildingRepository.findBuildingByAddress(building.getAddress());
        List<Building> buildings = user.getBuildings();
        if(buildingFromDB.isPresent()){
            user.getBuildings().add(buildingFromDB.get());
        }
        else {
            user.getBuildings().add(building);
        }
        return userRepository.save(user);
    }

    public void deleteAll(){
        userRepository.findAll().forEach(user -> {
            user.getBuildings().clear();
            userRepository.save(user);
        });
        userRepository.deleteAll();
    }
}
