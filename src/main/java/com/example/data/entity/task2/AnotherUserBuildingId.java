package com.example.data.entity.task2;

import lombok.Data;

import java.io.Serializable;

@Data
public class AnotherUserBuildingId implements Serializable {

    private long user;
    private long building;

    // getters/setters and most importantly equals() and hashCode()
}
