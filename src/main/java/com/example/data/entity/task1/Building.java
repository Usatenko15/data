package com.example.data.entity.task1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "BUILDING")
@Getter
@Setter
@EqualsAndHashCode(of = {"address", "userId"})
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id", nullable = false)
    private Long userId;

    @Column(name = "building_address")
    private String address;

    @ManyToMany(mappedBy = "buildings", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Building{" +
                "userId=" + userId +
                ", address='" + address + '\'' +
                '}';
    }
}
