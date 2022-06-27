package com.example.data.entity.task1;

import com.example.data.entity.task1.Building;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.repository.EntityGraph;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "USER")
@Getter
@Setter
@EqualsAndHashCode(of = {"name", "userId"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "user_name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "user_buildings",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "building_id")
    )
    private List<Building> buildings;

    public void addBuilding(Building building){
        buildings.add(building);
        building.getUsers().add(this);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", buildings=" + buildings +
                '}';
    }
}
