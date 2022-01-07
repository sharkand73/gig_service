package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharkey.music.gigservice.models.enums.VenueType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="venue")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @JsonIgnoreProperties(value = {"venue", "details"}, allowSetters = true)
    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column
    private double coordinatesN;

    @Column
    private double coordinatesW;

    @Column
    private VenueType venueType;

    @JsonIgnoreProperties("venue")
    @OneToMany(mappedBy = "venue", fetch = FetchType.LAZY)
    private List<Gig> gigs;


    public Venue(String name, Address address, VenueType venueType){
        this.name = name;
        this.address = address;
        this.venueType = venueType;
    }

    public Venue() {
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

    public double getCoordinatesN() {
        return coordinatesN;
    }

    public void setCoordinatesN(double coordinatesN) {
        this.coordinatesN = coordinatesN;
    }

    public double getCoordinatesW() {
        return coordinatesW;
    }

    public void setCoordinatesW(double coordinatesW) {
        this.coordinatesW = coordinatesW;
    }

    public VenueType getVenueType() {
        return venueType;
    }

    public void setVenueType(VenueType venueType) {
        this.venueType = venueType;
    }

    public List<Gig> getGigs() {
        return gigs;
    }

    public void setGigs(List<Gig> gigs) {
        this.gigs = gigs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}