package com.example.data.entity.task2;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_building")
@IdClass(AnotherUserBuildingId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"building","time"})
public class AnotherUserBuilding {

    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private AnotherUser user;

    @Id
    @ManyToOne
    @JoinColumn(name = "building_id", referencedColumnName = "building_id")
    private AnotherBuilding building;

    @Column
    private String time;
}
