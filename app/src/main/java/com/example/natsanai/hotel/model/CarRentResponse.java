package com.example.natsanai.hotel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by natsanai on 5/22/2018.
 */

public class CarRentResponse
{

    /**
     * status : 200
     * msg : OK
     * result : [{"location":"กรุงเทพ","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"YES","cddvd":"YES","bluetooth":"YES","rearcamera":"NO","vehicleDetailId":1,"engine":"1.8 ลิตร"}],"vehicleId":10001,"brand":"HONDA","numberplate":"กก-123","vehicleYear":2012,"seat":5,"price":1000,"picture":"P10001","model":"CIVIC"},{"location":"กรุงเทพ","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"NO","cddvd":"YES","bluetooth":"YES","rearcamera":"NO","vehicleDetailId":3,"engine":"1.5 ลิตร"}],"vehicleId":10003,"brand":"TOYOTA","numberplate":"กค-533","vehicleYear":2012,"seat":5,"price":1000,"picture":"P10003","model":"VIOS"},{"location":"นนทบุรีี","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"YES","cddvd":"YES","bluetooth":"YES","rearcamera":"NO","vehicleDetailId":2,"engine":"1.8 ลิตร"}],"vehicleId":10002,"brand":"HONDA","numberplate":"กข-254","vehicleYear":2013,"seat":5,"price":1100,"picture":"P10002","model":"CIVIC"},{"location":"นนทบุรี","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"NO","cddvd":"YES","bluetooth":"YES","rearcamera":"NO","vehicleDetailId":4,"engine":"1.5 ลิตร"}],"vehicleId":10004,"brand":"TOYOTA","numberplate":"กง-254","vehicleYear":2013,"seat":5,"price":1100,"picture":"P10004","model":"VIOS"},{"location":"นนทบุรี","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"NO","cddvd":"YES","bluetooth":"NO","rearcamera":"YES","vehicleDetailId":6,"engine":"1.2 ลิตร"}],"vehicleId":10006,"brand":"NISSAN","numberplate":"กฉ-432","vehicleYear":2016,"seat":4,"price":1150,"picture":"P10006","model":"NOTE"},{"location":"นนทบุรี","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"NO","cddvd":"YES","bluetooth":"YES","rearcamera":"NO","vehicleDetailId":8,"engine":"1.2 ลิตร"}],"vehicleId":10008,"brand":"MITSUBISHI","numberplate":"กฏ-987","vehicleYear":2016,"seat":4,"price":1150,"picture":"P10008","model":"MIRAGE"},{"location":"กรุงเทพ","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"NO","cddvd":"YES","bluetooth":"NO","rearcamera":"YES","vehicleDetailId":5,"engine":"1.2 ลิตร"}],"vehicleId":10005,"brand":"NISSAN","numberplate":"กจ-102","vehicleYear":2017,"seat":4,"price":1200,"picture":"P10005","model":"NOTE"},{"location":"กรุงเทพ","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"NO","cddvd":"YES","bluetooth":"YES","rearcamera":"NO","vehicleDetailId":7,"engine":"1.2 ลิตร"}],"vehicleId":10007,"brand":"MITSUBISHI","numberplate":"กช-333","vehicleYear":2017,"seat":4,"price":1200,"picture":"P10007","model":"MIRAGE"},{"location":"กรุงเทพ","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"YES","cddvd":"YES","bluetooth":"YES","rearcamera":"YES","vehicleDetailId":9,"engine":"3.2 ลิตร"}],"vehicleId":10009,"brand":"FORD","numberplate":"กณ-555","vehicleYear":2018,"seat":5,"price":1500,"picture":"P10009","model":"RANGER"},{"location":"นนทบุรี","vehicledetails":[{"transmission":"AUTO","cruisecontrol":"YES","cddvd":"YES","bluetooth":"YES","rearcamera":"YES","vehicleDetailId":10,"engine":"3.2 ลิตร"}],"vehicleId":10010,"brand":"FORD","numberplate":"กณ-556","vehicleYear":2018,"seat":5,"price":1500,"picture":"P10010","model":"RANGER"}]
     */

    private int status;
    @SerializedName("msg")
    private String message;
    private List<CarRent> result;

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

    public List<CarRent> getResult() {
        return result;
    }

    public void setResult(List<CarRent> result) {
        this.result = result;
    }

    public static class CarRent {
        /**
         * location : กรุงเทพ
         * vehicledetails : [{"transmission":"AUTO","cruisecontrol":"YES","cddvd":"YES","bluetooth":"YES","rearcamera":"NO","vehicleDetailId":1,"engine":"1.8 ลิตร"}]
         * vehicleId : 10001
         * brand : HONDA
         * numberplate : กก-123
         * vehicleYear : 2012
         * seat : 5
         * price : 1000
         * picture : P10001
         * model : CIVIC
         */

        private String location;
        private int vehicleId;
        private String brand;
        private String numberplate;
        private int vehicleYear;
        private int seat;
        private int price;
        private String picture;
        private String model;
        private List<Vehicledetails> vehicledetails;

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(int vehicleId) {
            this.vehicleId = vehicleId;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getNumberplate() {
            return numberplate;
        }

        public void setNumberplate(String numberplate) {
            this.numberplate = numberplate;
        }

        public int getVehicleYear() {
            return vehicleYear;
        }

        public void setVehicleYear(int vehicleYear) {
            this.vehicleYear = vehicleYear;
        }

        public int getSeat() {
            return seat;
        }

        public void setSeat(int seat) {
            this.seat = seat;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public List<Vehicledetails> getVehicledetails() {
            return vehicledetails;
        }

        public void setVehicledetails(List<Vehicledetails> vehicledetails) {
            this.vehicledetails = vehicledetails;
        }

        public static class Vehicledetails {
            /**
             * transmission : AUTO
             * cruisecontrol : YES
             * cddvd : YES
             * bluetooth : YES
             * rearcamera : NO
             * vehicleDetailId : 1
             * engine : 1.8 ลิตร
             */

            private String transmission;
            private String cruisecontrol;
            private String cddvd;
            private String bluetooth;
            private String rearcamera;
            private int vehicleDetailId;
            private String engine;

            public String getTransmission() {
                return transmission;
            }

            public void setTransmission(String transmission) {
                this.transmission = transmission;
            }

            public String getCruisecontrol() {
                return cruisecontrol;
            }

            public void setCruisecontrol(String cruisecontrol) {
                this.cruisecontrol = cruisecontrol;
            }

            public String getCddvd() {
                return cddvd;
            }

            public void setCddvd(String cddvd) {
                this.cddvd = cddvd;
            }

            public String getBluetooth() {
                return bluetooth;
            }

            public void setBluetooth(String bluetooth) {
                this.bluetooth = bluetooth;
            }

            public String getRearcamera() {
                return rearcamera;
            }

            public void setRearcamera(String rearcamera) {
                this.rearcamera = rearcamera;
            }

            public int getVehicleDetailId() {
                return vehicleDetailId;
            }

            public void setVehicleDetailId(int vehicleDetailId) {
                this.vehicleDetailId = vehicleDetailId;
            }

            public String getEngine() {
                return engine;
            }

            public void setEngine(String engine) {
                this.engine = engine;
            }
        }
    }
}
