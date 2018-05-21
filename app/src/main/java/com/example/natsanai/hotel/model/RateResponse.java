package com.example.natsanai.hotel.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by natsanai on 5/22/2018.
 */

public class RateResponse {

    /**
     * status : 200
     * msg : OK
     * result : [{"idRate":1,"source":"Bangkok","destination":"Krabi","detail":"funny","distance":"815","roundTripPrice":24450,"outboundPrice":16300,"enabled":1,"ispromotion":0,"picture":null},{"idRate":2,"source":"Bangkok","destination":"Kanchanaburi","detail":"-","distance":"150","roundTripPrice":4500,"outboundPrice":3000,"enabled":1,"ispromotion":0,"picture":null},{"idRate":3,"source":"Bangkok","destination":"Kalasin","detail":null,"distance":"520","roundTripPrice":15600,"outboundPrice":10400,"enabled":1,"ispromotion":0,"picture":null},{"idRate":4,"source":"Bangkok","destination":"Kamphaengphet","detail":null,"distance":"358","roundTripPrice":7160,"outboundPrice":3580,"enabled":1,"ispromotion":0,"picture":null},{"idRate":5,"source":"Bangkok","destination":"Chachoengsao","detail":null,"distance":"95","roundTripPrice":2,"outboundPrice":1,"enabled":1,"ispromotion":0,"picture":null},{"idRate":6,"source":"Bangkok","destination":"Khonkaen","detail":null,"distance":"450 ","roundTripPrice":13,"outboundPrice":9,"enabled":1,"ispromotion":0,"picture":null},{"idRate":7,"source":"Bangkok","destination":"Chanthaburi","detail":null,"distance":"250","roundTripPrice":7,"outboundPrice":5,"enabled":1,"ispromotion":0,"picture":null},{"idRate":8,"source":"Bangkok","destination":"Chainat","detail":null,"distance":"194","roundTripPrice":5,"outboundPrice":3,"enabled":1,"ispromotion":0,"picture":null},{"idRate":9,"source":"Bangkok","destination":"Chiangrai","detail":null,"distance":"785","roundTripPrice":23,"outboundPrice":15,"enabled":1,"ispromotion":0,"picture":null},{"idRate":10,"source":"Bangkok","destination":"Chonburi","detail":null,"distance":"120","roundTripPrice":3,"outboundPrice":2,"enabled":1,"ispromotion":0,"picture":null},{"idRate":11,"source":"Bangkok","destination":"Trat","detail":null,"distance":"315","roundTripPrice":9,"outboundPrice":6,"enabled":1,"ispromotion":0,"picture":null},{"idRate":12,"source":"Bangkok","destination":"Nakhonpathom","detail":null,"distance":"87","roundTripPrice":2,"outboundPrice":1,"enabled":1,"ispromotion":0,"picture":null},{"idRate":13,"source":"Bangkok","destination":"Chaiyaphum","detail":null,"distance":"340","roundTripPrice":10,"outboundPrice":6,"enabled":1,"ispromotion":0,"picture":null},{"idRate":14,"source":"Bangkok","destination":"Chumphon","detail":null,"distance":"463","roundTripPrice":13,"outboundPrice":9,"enabled":1,"ispromotion":0,"picture":null},{"idRate":15,"source":"Bangkok","destination":"Nakhonsithammarat","detail":null,"distance":"780 ","roundTripPrice":23,"outboundPrice":15,"enabled":1,"ispromotion":0,"picture":null},{"idRate":16,"source":"Bangkok","destination":"Nan","detail":null,"distance":"670","roundTripPrice":20,"outboundPrice":13,"enabled":1,"ispromotion":0,"picture":null},{"idRate":17,"source":"Bangkok","destination":"Chiangmai","detail":null,"distance":"690","roundTripPrice":20,"outboundPrice":13,"enabled":1,"ispromotion":0,"picture":null},{"idRate":18,"source":"Bangkok","destination":"Trang","detail":null,"distance":"828","roundTripPrice":27,"outboundPrice":16,"enabled":1,"ispromotion":0,"picture":null},{"idRate":19,"source":"Bangkok","destination":"Phrae","detail":null,"distance":"650","roundTripPrice":19,"outboundPrice":13,"enabled":1,"ispromotion":0,"picture":null},{"idRate":20,"source":"Bangkok","destination":"Mahasarakham","detail":null,"distance":"475","roundTripPrice":14,"outboundPrice":9,"enabled":1,"ispromotion":0,"picture":null},{"idRate":21,"source":"Bangkok","destination":"Phrae","detail":null,"distance":"650","roundTripPrice":19,"outboundPrice":13,"enabled":1,"ispromotion":0,"picture":null},{"idRate":22,"source":"Bangkok","destination":"Mahasarakham","detail":null,"distance":"475","roundTripPrice":14,"outboundPrice":9,"enabled":1,"ispromotion":0,"picture":null},{"idRate":29,"source":"gggg","destination":"gggg","detail":"ggg","distance":"456","roundTripPrice":456,"outboundPrice":123,"enabled":1,"ispromotion":0,"picture":null}]
     */

    private int status;
    @SerializedName("msg")
    private String message;
    private List<Rate> result;

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

    public List<Rate> getResult() {
        return result;
    }

    public void setResult(List<Rate> result) {
        this.result = result;
    }

    public static class Rate {
        /**
         * idRate : 1
         * source : Bangkok
         * destination : Krabi
         * detail : funny
         * distance : 815
         * roundTripPrice : 24450
         * outboundPrice : 16300
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
