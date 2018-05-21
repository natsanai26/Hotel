package com.example.natsanai.hotel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by natsanai on 5/22/2018.
 */

public class CarTypeResponse {

    /**
     * status : 200
     * msg : OK
     * result : [{"idCarType":5,"name":"private_car","carfare":800,"isready":1,"picture":"img001"},{"idCarType":6,"name":"bus_air","carfare":1200,"isready":1,"picture":"img003"}]
     */

    private int status;
    @SerializedName("msg")
    private String message;
    private List<CarType> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<CarType> getResult() {
        return result;
    }

    public void setResult(List<CarType> result) {
        this.result = result;
    }

    public static class CarType {
        /**
         * idCarType : 5
         * name : private_car
         * carfare : 800
         * isready : 1
         * picture : img001
         */

        private int idCarType;
        private String name;
        private int carfare;
        private int isready;
        private String picture;

        public int getIdCarType() {
            return idCarType;
        }

        public void setIdCarType(int idCarType) {
            this.idCarType = idCarType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCarfare() {
            return carfare;
        }

        public void setCarfare(int carfare) {
            this.carfare = carfare;
        }

        public int getIsready() {
            return isready;
        }

        public void setIsready(int isready) {
            this.isready = isready;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
