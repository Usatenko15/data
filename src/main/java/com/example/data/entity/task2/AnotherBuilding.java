package com.example.data.entity.task2;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "another_building")
@Getter
@Setter
@ToString(of = {"buildingId", "building_address"})
public class AnotherBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id", nullable = false)
    private Long buildingId;

    @Column(name = "building_address")
    private String address;

    @OneToMany(mappedBy = "building",fetch = FetchType.EAGER, orphanRemoval = true)
    private List<AnotherUserBuilding> usersAssoc;
}
