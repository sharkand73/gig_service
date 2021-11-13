package com.sharkey.music.gigservice.models;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.VenueType;

public class Venue {

    private String name;
    private Address address;
    private String coordinates;
    private VenueType venueType;

    public Venue(String name, Address address, VenueType venueType){
        this.name = name;
        this.address = address;
        this.venueType = venueType;
        this.coordinates = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public VenueType getVenueType() {
        return venueType;
    }

    public void setVenueType(VenueType venueType) {
        this.venueType = venueType;
    }
}