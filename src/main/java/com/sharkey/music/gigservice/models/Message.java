package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharkey.music.gigservice.models.enums.BookingMethod;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private LocalDate date;

    @Column(length = 1024)
    private String body;

    @Column
    private BookingMethod bookingMethod;

    @JsonIgnoreProperties(value = {"messages", "details", "organisation", "instruments", "groupsBooked"}, allowSetters = true)
    @ManyToOne
    @JoinColumn(name = "bookingGroup_id", referencedColumnName = "id")
    private BookingGroup bookingGroup;

    public Message(LocalDate date, BookingMethod bookingMethod,String body){
        this.date = date;
        this.body = body;
        this.bookingMethod = bookingMethod;
    }

    public Message(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public BookingGroup getBookingGroup() {
        return bookingGroup;
    }

    public void setBookingGroup(BookingGroup bookingGroup) {
        this.bookingGroup = bookingGroup;
    }

    public BookingMethod getBookingMethod() {
        return bookingMethod;
    }

    public void setBookingMethod(BookingMethod bookingMethod) {
        this.bookingMethod = bookingMethod;
    }
}
