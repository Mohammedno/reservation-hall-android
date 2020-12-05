package com.example.booking.models;

import com.google.gson.annotations.SerializedName;

public class UserReservation {



    @SerializedName("id")
    private String id;
    @SerializedName("date")
    private String date;
    @SerializedName("type")
    private String type;


    public UserReservation(String id, String date, String type) {
        this.id = id;
        this.date = date;
        this.type = type;
    }
    public String getId() {
        return this.id; }
    public void setId(String id) {
        this.id = id; }

    public String getDate() {
        return this.date; }
    public void setDate(String date) {
        this.date = date; }


    public String getType() {
        return this.type; }
    public void setTime(String type) {
        this.type = type; }


}
