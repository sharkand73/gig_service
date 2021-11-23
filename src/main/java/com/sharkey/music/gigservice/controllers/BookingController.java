package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Booking;
import com.sharkey.music.gigservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public List<Booking> getAllBookings() {return bookingRepository.findAll();}
}
