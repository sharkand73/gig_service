package com.sharkey.music.gigservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sharkey.music.gigservice.models.enums.PaymentMethod;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bookingGroup")
public class BookingGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bookingCode;

    @JsonIgnoreProperties(value = {"groupsBooked", "instruments", "address"})
    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person booker;

    @Column
    private LocalDate bookingDate;

    @JsonIgnoreProperties(value = "bookingGroup", allowSetters = true)
    @OneToMany(mappedBy = "bookingGroup", fetch = FetchType.LAZY)
    private List<Message> messages;

    @Column
    private PaymentMethod feePaymentMethod;

    @Column
    private PaymentMethod expensesPaymentMethod;

    @Column
    private boolean archived;

    @JsonIgnoreProperties(value = "bookingGroup", allowSetters = true)
    @OneToMany(mappedBy = "bookingGroup", fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public BookingGroup(Person booker, LocalDate bookingDate) {
        this.booker = booker;
        this.bookingDate = bookingDate;
        this.feePaymentMethod = PaymentMethod.BACS;
        this.expensesPaymentMethod = PaymentMethod.BACS;
        this.messages = new ArrayList<>();
    }

    public BookingGroup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public PaymentMethod getFeePaymentMethod() {
        return feePaymentMethod;
    }

    public void setFeePaymentMethod(PaymentMethod feePaymentMethod) {
        this.feePaymentMethod = feePaymentMethod;
    }

    public PaymentMethod getExpensesPaymentMethod() {
        return expensesPaymentMethod;
    }

    public void setExpensesPaymentMethod(PaymentMethod expensesPaymentMethod) {
        this.expensesPaymentMethod = expensesPaymentMethod;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public void removeMessage(Message message) {
        messages.remove(message);
    }
}
