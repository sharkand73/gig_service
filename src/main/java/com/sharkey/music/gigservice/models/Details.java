package com.sharkey.music.gigservice.models;

public class Details {

    private Address address;
    private String mobile;
    private String altPhone;
    private String email;
    private String altEmail;

    public Details(Address address, String mobile, String altPhone, String email, String altEmail){
        this.address = address;
        this.mobile = mobile;
        this.altPhone = altPhone;
        this.email = email;
        this.altEmail = altEmail;
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
}
