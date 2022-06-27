package com.example.data;

import com.example.data.entity.task1.Building;
import com.example.data.entity.task1.User;
import com.example.data.entity.task2.AnotherBuilding;
import com.example.data.entity.task2.AnotherUser;
import com.example.data.entity.task2.AnotherUserBuilding;
import com.example.data.entity.task3.Order;
import com.example.data.entity.task3.Task;
import com.example.data.repository.task1.BuildingRepository;
import com.example.data.repository.task1.UserRepository;
import com.example.data.repository.task2.AnotherBuildingRepository;
import com.example.data.repository.task2.AnotherUserBuildingRepository;
import com.example.data.repository.task2.AnotherUserRepository;
import com.example.data.repository.task3.OrderRepository;
import com.example.data.repository.task3.TaskRepository;
import com.example.data.service.task1.BuildingService;
import com.example.data.service.task1.FlowService;
import com.example.data.service.task2.AnotherBuildingService;
import com.example.data.service.task2.AnotherUserService;
import com.example.data.service.task3.TaskService;
import com.example.data.service.task1.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class Task1Test {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    AnotherBuildingRepository anotherBuildingRepository;

    @Autowired
    AnotherUserRepository anotherUserRepository;

    @Autowired
    AnotherUserBuildingRepository anotherUserBuildingRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserService userService;

    @Autowired
    TaskService taskService;

    @Autowired
    BuildingService buildingService;

    @Autowired
    AnotherUserService anotherUserService;

    @Autowired
    AnotherBuildingService anotherBuildingService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    FlowService flowService;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        buildingRepository.deleteAll();
    }


    @Test
    void task2Test() {
        AnotherUser anotherUser = new AnotherUser();
        anotherUser.setName("Nik");
        AnotherBuilding anotherBuilding = new AnotherBuilding();
        anotherBuilding.setAddress("gVyfdsfdsfsfdsgfdgfdgdfgdfgsadsadaborzka2332");
        AnotherBuilding anotherBuilding1 = new AnotherBuilding();
        anotherBuilding1.setAddress("gVyfdsfdsfsdborzka233dasdsadsa2");
        anotherUser.setBuildingsAssoc(List.of(new AnotherUserBuilding(anotherUser, anotherBuilding, "sdsds1123"),
                new AnotherUserBuilding(anotherUser, anotherBuilding1, "sdsds154")));
//        anotherUserService.create(anotherUser);
//        anotherBuildingService.deleteById(2l);
        anotherUserService.addBuildingByUserId(3l, anotherBuilding, "f123");


    }


    @Test
    void changeBuildingAddressById() {
        Building building = new Building();
        building.setAddress("changeBuildingById");
        Long createdBuildingId = buildingService.create(building).getUserId();
        String changedAddress = "changedAddress";
        buildingService.update(createdBuildingId, "changedAddress");
        assertEquals(changedAddress, buildingService.findById(createdBuildingId).getAddress());
    }

    @Test
    void addBuildingToUserByIdBuildingAbsentInDB() {
        User user = new User();
        user.setName("TestUser");
        Long userId = userService.create(user).getUserId();
        Building building = new Building();
        building.setAddress("buildingAddress");

        userService.addBuildingByUserId(userId, building);
        user = userService.findById(userId);
        Building createdBuilding = user.getBuildings().get(0);
        assertEquals(createdBuilding.getAddress(), building.getAddress());
    }

    @Test
    void addBuildingToUserByIdBuildingExistInDB() {
        User user = new User();
        user.setName("TestUser");
        Long userId = userService.create(user).getUserId();
        Building building = new Building();
        building.setAddress("buildingAddress");
        building = buildingService.create(building);

        userService.addBuildingByUserId(userId, building);

        user = userRepository.findById(userId).get();
        User user1 = userRepository.findByName("TestUser").get(0);
        Building createdBuilding = buildingRepository.findBuildingByUserId(1l).get().get(0);
        assertEquals(createdBuilding.getAddress(), building.getAddress());
    }

    @Test
    void deleteBuildingById() {
//        buildingRepository.deleteAll();;
        User user = new User();
        user.setName("TestUser");
        Building building = new Building();
        building.setAddress("buildingAddress");
        Building building2 = new Building();
        building2.setAddress("buildingAddress1");
        List<Building> buildings = new ArrayList<>();
        buildings.add(building);
        buildings.add(building2);
        user.setBuildings(buildings);
        user = userService.create(user);

        building = user.getBuildings().get(0);
        buildingService.deleteById(building.getUserId());
        Building createdBuilding = user.getBuildings().get(0);
        assertEquals(createdBuilding.getAddress(), building.getAddress());
    }

}
