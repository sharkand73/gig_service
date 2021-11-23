package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @JsonIgnoreProperties("person")
    @OneToOne
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private Details details;

    @ManyToOne
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    private Organisation organisation;

    @JsonIgnoreProperties("persons")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "person_instrument",
            joinColumns = {
                    @JoinColumn(name = "person_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "instrument_id", nullable = false, updatable = false)
            }
    )
    private List<Instrument> instruments;

    @JsonIgnoreProperties("booker")
    @OneToMany(mappedBy = "booker", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Person(String firstName, String lastName, Details details, Organisation organisation){
        this.firstName = firstName;
        this.lastName = lastName;
        this.details = details;
        this.organisation = organisation;
        this.instruments = new ArrayList<>();
    }

    public Person() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String findMobile(){
        return this.getDetails().getMobile();
    }

    public String findAltPhone(){
        return this.getDetails().getAltPhone();
    }

    public String findEmail(){
        return this.getDetails().getEmail();
    }

    public String findAltEmail(){
        return this.getDetails().getAltEmail();
    }

    public String findAddressLine1(){
        return this.getDetails().getAddress().getAddressLine1();
    }

    public String findddressLine2(){
        return this.getDetails().getAddress().getAddressLine2();
    }

    public String findCity(){
        return this.getDetails().getAddress().getCity();
    }

    public String findRegion(){
        return this.getDetails().getAddress().getRegion();
    }

    public String findPostcode(){
        return this.getDetails().getAddress().getPostcode();
    }
    public void addInstrument(Instrument instrument){
        this.instruments.add(instrument);
    }
}
