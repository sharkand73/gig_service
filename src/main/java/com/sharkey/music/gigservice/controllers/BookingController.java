package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Booking;
import com.sharkey.music.gigservice.models.BookingGroup;
import com.sharkey.music.gigservice.models.Person;
import com.sharkey.music.gigservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public List<Booking> getAllBookings() {return bookingRepository.findAll();}


    @GetMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/bookings")
    public ResponseEntity<Booking> postBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/bookings/batch")
    public ResponseEntity<List<Booking>> postBookings(@RequestBody List<Booking> bookings){
        for(Booking booking : bookings) {
            bookingRepository.save(booking);
        }
        return new ResponseEntity<>(bookings, HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/bookings/{id}")
    public ResponseEntity<Long> deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/bookings/{id}")
    public ResponseEntity<Booking> putBooking(@RequestBody Booking booking, @PathVariable Long id){
        Booking foundBooking = bookingRepository.findById(id).get();
        foundBooking.setStatus(booking.getStatus());
        foundBooking.setDateConfirmed(booking.getDateConfirmed());
        foundBooking.setDateCancelled(booking.getDateCancelled());
        foundBooking.setDateFeePaid(booking.getDateFeePaid());
        foundBooking.setFee(booking.getFee());
        foundBooking.setExpenses(booking.getExpenses());
        foundBooking.setDateExpensesPaid(booking.getDateExpensesPaid());
        foundBooking.setBookingGroup(booking.getBookingGroup());
        bookingRepository.save(foundBooking);
        return new ResponseEntity<>(foundBooking, HttpStatus.OK);
    }
}
