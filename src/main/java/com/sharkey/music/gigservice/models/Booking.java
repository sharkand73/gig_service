package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharkey.music.gigservice.models.enums.BookingMethod;
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

    @JsonIgnoreProperties("bookings")
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person booker;

    @Column
    private LocalDate bookingDate;

    @Column
    private BookingMethod bookingMethod;
    @Column
    private String message;
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
    private PaymentMethod feePaymentMethod;
    @Column
    private double expenses;
    @Column
    private LocalDate dateExpensesPaid;
    @Column
    private PaymentMethod expensesPaymentMethod;

    @JsonIgnoreProperties("booking")
    @OneToOne(mappedBy = "booking")
    private Gig gig;

    public Booking(Person booker, LocalDate bookingDate, BookingMethod bookingMethod, String message, double fee) {
        this.booker = booker;
        this.bookingDate = bookingDate;
        this.bookingMethod = bookingMethod;
        this.message = message;
        this.fee = fee;
        this.status = BookingStatus.CONFIRMED;
    }

    public Booking() {
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
