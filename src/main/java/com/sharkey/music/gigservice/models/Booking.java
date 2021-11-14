package com.sharkey.music.gigservice.models;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {

    private Person booker;
    private LocalDate bookingDate;
    private BookingMethod bookingMethod;
    private String message;
    private BookingStatus status;
    private LocalDate dateConfirmed;
    private LocalDate dateCancelled;
    private LocalDate dateFeePaid;
    private double fee;
    private PaymentMethod feePaymentMethod;
    private double expenses;
    private LocalDate dateExpensesPaid;
    private PaymentMethod expensesPaymentMethod;

    public Booking(Person booker, LocalDate bookingDate, BookingMethod bookingMethod, String message, double fee) {
        this.booker = booker;
        this.bookingDate = bookingDate;
        this.bookingMethod = bookingMethod;
        this.message = message;
        this.fee = fee;
        this.status = BookingStatus.CONFIRMED;
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

    public BookingMethod getBookingMethod() {
        return bookingMethod;
    }

    public void setBookingMethod(BookingMethod bookingMethod) {
        this.bookingMethod = bookingMethod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public PaymentMethod getFeePaymentMethod() {
        return feePaymentMethod;
    }

    public void setFeePaymentMethod(PaymentMethod feePaymentMethod) {
        this.feePaymentMethod = feePaymentMethod;
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

    public PaymentMethod getExpensesPaymentMethod() {
        return expensesPaymentMethod;
    }

    public void setExpensesPaymentMethod(PaymentMethod expensesPaymentMethod) {
        this.expensesPaymentMethod = expensesPaymentMethod;
    }
}
