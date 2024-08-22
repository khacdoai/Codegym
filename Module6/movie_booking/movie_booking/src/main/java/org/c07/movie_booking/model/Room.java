package org.c07.movie_booking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roomName;
    private  int qualitySeat;
    private String status;
    private String description;

    public Room() {
    }

    public Room(long id, String roomName, int qualitySeat, String status, String description) {
        this.id = id;
        this.roomName = roomName;
        this.qualitySeat = qualitySeat;
        this.status = status;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getQualitySeat() {
        return qualitySeat;
    }

    public void setQualitySeat(int qualitySeat) {
        this.qualitySeat = qualitySeat;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
