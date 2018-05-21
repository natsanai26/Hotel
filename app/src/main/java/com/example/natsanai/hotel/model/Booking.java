package com.example.natsanai.hotel.model;

/**
 * Created by natsanai on 5/21/2018.
 */

public class Booking
{

    /**
     * bookingId : 8
     * dateCheckIn : 1522602000000
     * dateCheckOut : 1522688400000
     * email : natsanai24@gmail.com
     * name :
     * number :
     * roomId : 2
     */

    private int bookingId;
    private long dateCheckIn;
    private long dateCheckOut;
    private String email;
    private String name;
    private String number;
    private int roomId;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public long getDateCheckIn() {
        return dateCheckIn;
    }

    public void setDateCheckIn(long dateCheckIn) {
        this.dateCheckIn = dateCheckIn;
    }

    public long getDateCheckOut() {
        return dateCheckOut;
    }

    public void setDateCheckOut(long dateCheckOut) {
        this.dateCheckOut = dateCheckOut;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
