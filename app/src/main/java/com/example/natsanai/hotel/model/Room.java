package com.example.natsanai.hotel.model;

/**
 * Created by natsanai on 5/20/2018.
 */

public class Room
{

    /**
     * maxPerson : 4
     * place : Kanchanaburi
     * price : 100
     * roomCategory : Normal
     * roomId : 2
     * roomStatus : Available
     */

    private int maxPerson;
    private String place;
    private int price;
    private String roomCategory;
    private int roomId;
    private String roomStatus;

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
