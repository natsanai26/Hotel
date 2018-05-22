package com.example.natsanai.hotel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by natsanai on 5/22/2018.
 */

public class CarBookingResponse
{

    /**
     * status : 200
     * msg : OK
     * result : [{"idBooking":34,"carType":{"idCarType":3,"name":"vans","carfare":500,"isready":1,"picture":"img004"},"member":{"idMember":19,"name":null,"surname":null,"username":null,"password":null,"email":"sumit@mymail.com","phoneNumber":null,"role":"member"},"rate":{"idRate":2,"source":"Bangkok","destination":"Kanchanaburi","detail":"-","distance":"150","roundTripPrice":4500,"outboundPrice":3000,"enabled":1,"ispromotion":0,"picture":null},"detail":"ggwp","payment":"9999","numCar":1,"numPassenger":1,"place":"ku","departureDate":"1970-01-01","status":null,"totalPrice":5000},{"idBooking":35,"carType":{"idCarType":4,"name":"bus","carfare":700,"isready":1,"picture":"img002"},"member":{"idMember":20,"name":null,"surname":null,"username":null,"password":null,"email":"shh@fg","phoneNumber":null,"role":"member"},"rate":{"idRate":10,"source":"Bangkok","destination":"Chonburi","detail":null,"distance":"120","roundTripPrice":3,"outboundPrice":2,"enabled":1,"ispromotion":0,"picture":null},"detail":"dd","payment":"100","numCar":1,"numPassenger":1,"place":"ghj","departureDate":"1970-01-01","status":null,"totalPrice":703},{"idBooking":36,"carType":{"idCarType":5,"name":"private_car","carfare":800,"isready":1,"picture":"img001"},"member":{"idMember":19,"name":null,"surname":null,"username":null,"password":null,"email":"sumit@mymail.com","phoneNumber":null,"role":"member"},"rate":{"idRate":8,"source":"Bangkok","destination":"Chainat","detail":null,"distance":"194","roundTripPrice":5,"outboundPrice":3,"enabled":1,"ispromotion":0,"picture":null},"detail":"dd","payment":"99999","numCar":1,"numPassenger":1,"place":"kuku","departureDate":"1970-01-01","status":null,"totalPrice":805},{"idBooking":37,"carType":{"idCarType":5,"name":"private_car","carfare":800,"isready":1,"picture":"img001"},"member":{"idMember":21,"name":null,"surname":null,"username":null,"password":null,"email":"sux@mymail.com","phoneNumber":null,"role":"member"},"rate":{"idRate":10,"source":"Bangkok","destination":"Chonburi","detail":null,"distance":"120","roundTripPrice":3,"outboundPrice":2,"enabled":1,"ispromotion":0,"picture":null},"detail":"goj","payment":"9999","numCar":1,"numPassenger":1,"place":"gol","departureDate":"1970-01-01","status":null,"totalPrice":803},{"idBooking":38,"carType":{"idCarType":5,"name":"private_car","carfare":800,"isready":1,"picture":"img001"},"member":{"idMember":21,"name":null,"surname":null,"username":null,"password":null,"email":"sux@mymail.com","phoneNumber":null,"role":"member"},"rate":{"idRate":8,"source":"Bangkok","destination":"Chainat","detail":null,"distance":"194","roundTripPrice":5,"outboundPrice":3,"enabled":1,"ispromotion":0,"picture":null},"detail":"doa","payment":"9999","numCar":1,"numPassenger":1,"place":"hih","departureDate":"1970-01-01","status":null,"totalPrice":805},{"idBooking":39,"carType":{"idCarType":6,"name":"bus_air","carfare":1200,"isready":1,"picture":"img003"},"member":{"idMember":22,"name":null,"surname":null,"username":null,"password":null,"email":"dao@mymail.com","phoneNumber":null,"role":"member"},"rate":{"idRate":13,"source":"Bangkok","destination":"Chaiyaphum","detail":null,"distance":"340","roundTripPrice":10,"outboundPrice":6,"enabled":1,"ispromotion":0,"picture":null},"detail":"hhh","payment":"888","numCar":1,"numPassenger":1,"place":"gg","departureDate":"1970-01-01","status":null,"totalPrice":1210},{"idBooking":40,"carType":{"idCarType":3,"name":"vans","carfare":500,"isready":1,"picture":"img004"},"member":{"idMember":23,"name":null,"surname":null,"username":null,"password":null,"email":"piiz.pumz@hotmail.com","phoneNumber":null,"role":"member"},"rate":{"idRate":1,"source":"Bangkok","destination":"Krabi","detail":"funny","distance":"815","roundTripPrice":24450,"outboundPrice":16300,"enabled":1,"ispromotion":0,"picture":null},"detail":"","payment":"","numCar":1,"numPassenger":4,"place":"","departureDate":"2018-05-22","status":null,"totalPrice":24950}]
     */

    private int status;
    @SerializedName("msg")
    private String message;
    private List<Booking> result;

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

    public List<Booking> getResult() {
        return result;
    }

    public void setResult(List<Booking> result) {
        this.result = result;
    }

    public static class Booking {
        /**
         * idBooking : 34
         * carType : {"idCarType":3,"name":"vans","carfare":500,"isready":1,"picture":"img004"}
         * member : {"idMember":19,"name":null,"surname":null,"username":null,"password":null,"email":"sumit@mymail.com","phoneNumber":null,"role":"member"}
         * rate : {"idRate":2,"source":"Bangkok","destination":"Kanchanaburi","detail":"-","distance":"150","roundTripPrice":4500,"outboundPrice":3000,"enabled":1,"ispromotion":0,"picture":null}
         * detail : ggwp
         * payment : 9999
         * numCar : 1
         * numPassenger : 1
         * place : ku
         * departureDate : 1970-01-01
         * status : null
         * totalPrice : 5000
         */

        private int idBooking;
        private CarTypeBean carType;
        private MemberBean member;
        private RateBean rate;
        private String detail;
        private String payment;
        private int numCar;
        private int numPassenger;
        private String place;
        private String departureDate;
        private Object status;
        private int totalPrice;

        public int getIdBooking() {
            return idBooking;
        }

        public void setIdBooking(int idBooking) {
            this.idBooking = idBooking;
        }

        public CarTypeBean getCarType() {
            return carType;
        }

        public void setCarType(CarTypeBean carType) {
            this.carType = carType;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public RateBean getRate() {
            return rate;
        }

        public void setRate(RateBean rate) {
            this.rate = rate;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getPayment() {
            return payment;
        }

        public void setPayment(String payment) {
            this.payment = payment;
        }

        public int getNumCar() {
            return numCar;
        }

        public void setNumCar(int numCar) {
            this.numCar = numCar;
        }

        public int getNumPassenger() {
            return numPassenger;
        }

        public void setNumPassenger(int numPassenger) {
            this.numPassenger = numPassenger;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getDepartureDate() {
            return departureDate;
        }

        public void setDepartureDate(String departureDate) {
            this.departureDate = departureDate;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
        }

        public int getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(int totalPrice) {
            this.totalPrice = totalPrice;
        }

        public static class CarTypeBean {
            /**
             * idCarType : 3
             * name : vans
             * carfare : 500
             * isready : 1
             * picture : img004
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

        public static class MemberBean {
            /**
             * idMember : 19
             * name : null
             * surname : null
             * username : null
             * password : null
             * email : sumit@mymail.com
             * phoneNumber : null
             * role : member
             */

            private int idMember;
            private Object name;
            private Object surname;
            private Object username;
            private Object password;
            private String email;
            private Object phoneNumber;
            private String role;

            public int getIdMember() {
                return idMember;
            }

            public void setIdMember(int idMember) {
                this.idMember = idMember;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getSurname() {
                return surname;
            }

            public void setSurname(Object surname) {
                this.surname = surname;
            }

            public Object getUsername() {
                return username;
            }

            public void setUsername(Object username) {
                this.username = username;
            }

            public Object getPassword() {
                return password;
            }

            public void setPassword(Object password) {
                this.password = password;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public Object getPhoneNumber() {
                return phoneNumber;
            }

            public void setPhoneNumber(Object phoneNumber) {
                this.phoneNumber = phoneNumber;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class RateBean {
            /**
             * idRate : 2
             * source : Bangkok
             * destination : Kanchanaburi
             * detail : -
             * distance : 150
             * roundTripPrice : 4500
             * outboundPrice : 3000
             * enabled : 1
             * ispromotion : 0
             * picture : null
             */

            private int idRate;
            private String source;
            private String destination;
            private String detail;
            private String distance;
            private int roundTripPrice;
            private int outboundPrice;
            private int enabled;
            private int ispromotion;
            private Object picture;

            public int getIdRate() {
                return idRate;
            }

            public void setIdRate(int idRate) {
                this.idRate = idRate;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getDestination() {
                return destination;
            }

            public void setDestination(String destination) {
                this.destination = destination;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public int getRoundTripPrice() {
                return roundTripPrice;
            }

            public void setRoundTripPrice(int roundTripPrice) {
                this.roundTripPrice = roundTripPrice;
            }

            public int getOutboundPrice() {
                return outboundPrice;
            }

            public void setOutboundPrice(int outboundPrice) {
                this.outboundPrice = outboundPrice;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public int getIspromotion() {
                return ispromotion;
            }

            public void setIspromotion(int ispromotion) {
                this.ispromotion = ispromotion;
            }

            public Object getPicture() {
                return picture;
            }

            public void setPicture(Object picture) {
                this.picture = picture;
            }
        }
    }
}
