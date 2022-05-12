package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @JsonIgnoreProperties(value = {"details", "venue"}, allowSetters = true)
    @OneToOne(cascade = CascadeType.REMOVE) // CascadeType.ALL causing issues.  Why?
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(mappedBy = "details")
    private Person person;

    @Column
    private String mobile;
    @Column(name = "alt_phone")
    private String altPhone;
    @Column
    private String email;
    @Column(name = "alt_email")
    private String altEmail;

    public Details(Address address, String mobile, String altPhone, String email, String altEmail){
        this.address = address;
        this.mobile = mobile;
        this.altPhone = altPhone;
        this.email = email;
        this.altEmail = altEmail;
    }

    public Details() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAltPhone() {
        return altPhone;
    }

    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAltEmail() {
        return altEmail;
    }

    public void setAltEmail(String altEmail) {
        this.altEmail = altEmail;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
