package com.sharkey.music.gigservice.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {

    private Person booker;
    private LocalDate bookingDate;
    private String message;
    private boolean confirmed;
    private LocalDate dateConfirmed;
    private BookingMethod bookingMethod;
    private Payment fee;
    private Payment cancellationFee;
    private boolean cancelled;
    private Payment expenses;

    public Booking(Person booker, LocalDate bookingDate, String message, BookingMethod bookingMethod, Payment fee) {
        this.booker = booker;
        this.bookingDate = bookingDate;
        this.message = message;
        this.bookingMethod = bookingMethod;
        this.fee = fee;
//        this.confirmed = false;
//        this.cancelled = false;
    }

    public Person getBooker() {
        return booker;
    }

    public void setBooker(Person booker) {
        this.booker = booker;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public LocalDate getDateConfirmed() {
        return dateConfirmed;
    }

    public void setDateConfirmed(LocalDate dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public BookingMethod getBookingMethod() {
        return bookingMethod;
    }

    public void setBookingMethod(BookingMethod bookingMethod) {
        this.bookingMethod = bookingMethod;
    }

    public Payment getFee() {
        return fee;
    }

    public void setFee(Payment fee) {
        this.fee = fee;
    }

    public Payment getCancellationFee() {
        return cancellationFee;
    }

    public void setCancellationFee(Payment cancellationFee) {
        this.cancellationFee = cancellationFee;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public Payment getExpenses() {
        return expenses;
    }

    public void setExpenses(Payment expenses) {
        this.expenses = expenses;
    }
}
