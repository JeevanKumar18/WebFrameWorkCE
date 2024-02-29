package com.example.ex3.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Door {
    @Id
    private int doorId;
    private String location;
    private String accessCode;
    private String accessType;
    public Door(int doorId, String location, String accessCode, String accessType) {
        this.doorId = doorId;
        this.location = location;
        this.accessCode = accessCode;
        this.accessType = accessType;
    }
    public Door() {
    }
    public int getDoorId() {
        return doorId;
    }
    public String getLocation() {
        return location;
    }
    public String getAccessCode() {
        return accessCode;
    }
    public String getAccessType() {
        return accessType;
    }
    
}
