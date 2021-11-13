package com.sharkey.music.gigservice.models;

import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

public class Gig {

    private Booking booking;
    private Act act;
    private LocalDateTime arrivalTime;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int playingTime;
    private Venue venue;
    private DressCode dressCode;
    private boolean soundCheck;
    private boolean foodProvided;

    public Gig(Booking booking, Act act, LocalDateTime arrivalTime, LocalDateTime startTime, LocalDateTime endTime, int playingTime, Venue venue, DressCode dressCode, boolean soundCheck, boolean foodProvided) {
        this.booking = booking;
        this.act = act;
        this.arrivalTime = arrivalTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.playingTime = playingTime;
        this.venue = venue;
        this.dressCode = dressCode;
        this.soundCheck = soundCheck;
        this.foodProvided = foodProvided;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public DressCode getDressCode() {
        return dressCode;
    }

    public void setDressCode(DressCode dressCode) {
        this.dressCode = dressCode;
    }

    public boolean isSoundCheck() {
        return soundCheck;
    }

    public void setSoundCheck(boolean soundCheck) {
        this.soundCheck = soundCheck;
    }

    public boolean isFoodProvided() {
        return foodProvided;
    }

    public void setFoodProvided(boolean foodProvided) {
        this.foodProvided = foodProvided;
    }
}
