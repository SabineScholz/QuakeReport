package com.example.android.quakereport;

import java.util.Calendar;

/**
 * Created by Sabine on 25.03.2018.
 */

public class Earthquake {

    private double magnitude;
    private String place;
    private Calendar date;

    public Earthquake(double magnitude, String place, Calendar date) {
        this.magnitude = magnitude;
        this.place = place;
        this.date = date;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

}
