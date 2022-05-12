package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharkey.music.gigservice.models.enums.BookingStatus;
import com.sharkey.music.gigservice.models.enums.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
    @Table(name="booking")
    public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BookingStatus status;
    @Column
    private LocalDate dateConfirmed;
    @Column
    private LocalDate dateCancelled;
    @Column
    private LocalDate dateFeePaid;
    @Column
    private double fee;
    @Column
    private double expenses;
    @Column
    private LocalDate dateExpensesPaid;

    @JsonIgnoreProperties(value = {"bookings", "details", "organisation", "messages"})
    @ManyToOne
    @JoinColumn(name = "bookingGroup_id", referencedColumnName = "id")
    private BookingGroup bookingGroup;

    @JsonIgnoreProperties(value = "booking")
    @OneToOne(mappedBy = "booking", fetch = FetchType.LAZY)
    //@JoinColumn(name = "gig_id", referencedColumnName = "id")
    private Gig gig;

    public Booking(double fee, BookingStatus status){
        this.fee = fee;
        this.status = status;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public LocalDate getDateConfirmed() {
        return dateConfirmed;
    }

    public void setDateConfirmed(LocalDate dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public LocalDate getDateCancelled() {
        return dateCancelled;
    }

    public void setDateCancelled(LocalDate dateCancelled) {
        this.dateCancelled = dateCancelled;
    }

    public LocalDate getDateFeePaid() {
        return dateFeePaid;
    }

    public void setDateFeePaid(LocalDate dateFeePaid) {
        this.dateFeePaid = dateFeePaid;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public LocalDate getDateExpensesPaid() {
        return dateExpensesPaid;
    }

    public void setDateExpensesPaid(LocalDate dateExpensesPaid) {
        this.dateExpensesPaid = dateExpensesPaid;
    }

    public BookingGroup getBookingGroup() {
        return bookingGroup;
    }

    public void setBookingGroup(BookingGroup bookingGroup) {
        this.bookingGroup = bookingGroup;
    }

    public Gig getGig() {
        return gig;
    }

    public void setGig(Gig gig) {
        this.gig = gig;
    }
}
