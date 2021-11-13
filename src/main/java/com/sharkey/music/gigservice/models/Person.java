package com.sharkey.music.gigservice.models;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String firstName;
    private String lastName;
    private Details details;
    private Organisation organisation;
    private List<Instrument> instruments;

    public Person(String firstName, String lastName, Details details, Organisation organisation){
        this.firstName = firstName;
        this.lastName = lastName;
        this.details = details;
        this.organisation = organisation;
        this.instruments = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }
}
