package com.sharkey.music.gigservice.models;

import java.time.LocalDate;

public class Payment {

    private double amount;
    private LocalDate datePaid;
    private PaymentMethod paymentMethod;
    private int paymentWaitInDays;

    public Payment(double amount, PaymentMethod paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDatePaid() {
        return datePaid;
    }

    public void setDatePaid(LocalDate datePaid) {
        this.datePaid = datePaid;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentWaitInDays() {
        return paymentWaitInDays;
    }

    public void setPaymentWaitInDays(int paymentWaitInDays) {
        this.paymentWaitInDays = paymentWaitInDays;
    }
}
