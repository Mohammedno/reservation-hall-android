package com.example.booking.models;

import com.google.gson.annotations.SerializedName;

public class Reserve {


        @SerializedName("date")
        private String date;
        @SerializedName("type")
        private String type;
        @SerializedName("user_id")
        private String user_id;

        public Reserve(String date, String type, String user_id) {

            this.date = date;
            this.type = type;
            this.user_id = user_id;
        }

        public String getDate() {
            return this.date; }
        public void setDate(String date) {
            this.date = date; }


        public String getType() {
            return this.type; }
        public void setType(String type) {
            this.type = type; }

        public String getUserId() {
            return this.user_id; }
        public void setUserId(String user_id) {
            this.user_id = user_id; }

}
