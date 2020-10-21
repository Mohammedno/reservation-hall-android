package com.example.booking.models;

import com.google.gson.annotations.SerializedName;
public class Reservation {


        @SerializedName("date")
        private String date;
        @SerializedName("dinner")
        private String dinner;
        @SerializedName("lunch")
        private String lunch;

        public Reservation(String date, String dinner, String lunch) {

            this.date = date;
            this.dinner = dinner;
            this.lunch = lunch;
        }

        public String getDate() {
            return this.date; }
        public void setDate(String date) {
            this.date = date; }


        public String getDinner() {
            return this.dinner; }
        public void setDinner(String dinner) {
            this.dinner = dinner; }

        public String getLunch() {
            return this.lunch; }
        public void setLunch(String lunch) {
            this.lunch = lunch; }

}
