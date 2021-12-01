package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Booking;
import com.sharkey.music.gigservice.models.Person;
import com.sharkey.music.gigservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public List<Booking> getAllBookings() {return bookingRepository.findAll();}


    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/booking")
    public ResponseEntity<Booking> postUser(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking, @PathVariable Long id){
        Booking foundBooking = bookingRepository.findById(id).get();
        foundBooking.setBooker(booking.getBooker());
        foundBooking.setBookingDate(booking.getBookingDate());
        foundBooking.setBookingMethod(booking.getBookingMethod());
        foundBooking.setMessage(booking.getMessage());
        foundBooking.setStatus(booking.getStatus());
        foundBooking.setDateConfirmed(booking.getDateConfirmed());
        foundBooking.setDateCancelled(booking.getDateCancelled());
        foundBooking.setDateFeePaid(booking.getDateFeePaid());
        foundBooking.setFee(booking.getFee());
        foundBooking.setFeePaymentMethod(booking.getFeePaymentMethod());
        foundBooking.setExpenses(booking.getExpenses());
        foundBooking.setDateExpensesPaid(booking.getDateExpensesPaid());
        foundBooking.setExpensesPaymentMethod(booking.getExpensesPaymentMethod());
        bookingRepository.save(foundBooking);
        return new ResponseEntity<>(foundBooking, HttpStatus.OK);
    }
}
