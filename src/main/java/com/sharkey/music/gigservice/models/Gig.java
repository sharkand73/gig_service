package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharkey.music.gigservice.models.enums.BassType;
import com.sharkey.music.gigservice.models.enums.DressCode;
import com.sharkey.music.gigservice.models.enums.GigType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "gig")
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @JsonIgnoreProperties(value = "gig", allowSetters = true)
    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @JsonIgnoreProperties("gigs")
    @ManyToOne
    @JoinColumn(name = "act_id", referencedColumnName = "id")
    private Act act;

    @Column
    private LocalDateTime arrivalTime;
    @Column
    private LocalDateTime startTime;
    @Column
    private LocalDateTime endTime;
    @Column
    private int playingTime;

    @JsonIgnoreProperties("gigs")
    @ManyToOne
    @JoinColumn(name = "venue_id", referencedColumnName = "id")
    private Venue venue;

    @Column
    private GigType gigType;

    @Column
    private BassType bass;

    @Column
    private DressCode dressCode;

    @Column
    private boolean soundCheck;

    @Column
    private boolean foodProvided;

    @Column
    private int distanceDriven;

    @Column
    private double moneySpent;

    public Gig(Booking booking, Act act, LocalDateTime arrivalTime, LocalDateTime startTime, LocalDateTime endTime, int playingTime, Venue venue, GigType gigType, DressCode dressCode, boolean soundCheck, boolean foodProvided) {
        this.booking = booking;
        this.act = act;
        this.arrivalTime = arrivalTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.playingTime = playingTime;
        this.venue = venue;
        this.gigType = gigType;
        this.dressCode = dressCode;
        this.soundCheck = soundCheck;
        this.foodProvided = foodProvided;
        this.moneySpent = moneySpent;
        this.distanceDriven = distanceDriven;
    }

    public Gig() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public GigType getGigType() {
        return gigType;
    }

    public void setGigType(GigType gigType) {
        this.gigType = gigType;
    }

    public BassType getBass() {
        return bass;
    }

    public void setBass(BassType bass) {
        this.bass = bass;
    }

    public boolean isSoundCheck() {
        return soundCheck;
    }

    public boolean isFoodProvided() {
        return foodProvided;
    }

    public void setSoundCheck(boolean soundCheck) {
        this.soundCheck = soundCheck;
    }

    public void setFoodProvided(boolean foodProvided) {
        this.foodProvided = foodProvided;
    }

    public DressCode getDressCode() {
        return dressCode;
    }

    public void setDressCode(DressCode dressCode) {
        this.dressCode = dressCode;
    }

    public int getDistanceDriven() {
        return distanceDriven;
    }

    public void setDistanceDriven(int distanceDriven) {
        this.distanceDriven = distanceDriven;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

}
