package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Booking;
import com.sharkey.music.gigservice.models.BookingGroup;
import com.sharkey.music.gigservice.repositories.BookingGroupRepository;
import com.sharkey.music.gigservice.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingGroupController {
    @Autowired
    BookingGroupRepository bookingGroupRepository;

    @GetMapping(value = "/groups")
    public List<BookingGroup> getAllGroups() {return bookingGroupRepository.findAll();}


    @GetMapping(value = "/groups/{id}")
    public ResponseEntity<BookingGroup> getGroup(@PathVariable Long id){
        return new ResponseEntity(bookingGroupRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/groups")
    public ResponseEntity<BookingGroup> postGroup(@RequestBody BookingGroup bookingGroup){
        bookingGroupRepository.save(bookingGroup);
        return new ResponseEntity<>(bookingGroup, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/groups/batch")
    public ResponseEntity<List<BookingGroup>> postGroups(@RequestBody List<BookingGroup> groups){
        for(BookingGroup group : groups) {
            bookingGroupRepository.save(group);
        }
        return new ResponseEntity<>(groups, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/groups/{id}")
    public ResponseEntity<Long> deleteGroup(@PathVariable Long id){
        bookingGroupRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/groups/{id}")
    public ResponseEntity<BookingGroup> putGroup(@RequestBody BookingGroup bookingGroup, @PathVariable Long id){
        BookingGroup foundBookingGroup = bookingGroupRepository.findById(id).get();
        foundBookingGroup.setBooker(bookingGroup.getBooker());
        foundBookingGroup.setBookingDate(bookingGroup.getBookingDate());
        foundBookingGroup.setFeePaymentMethod(bookingGroup.getFeePaymentMethod());
        foundBookingGroup.setExpensesPaymentMethod(bookingGroup.getExpensesPaymentMethod());
        bookingGroupRepository.save(foundBookingGroup);
        return new ResponseEntity<>(foundBookingGroup, HttpStatus.OK);
    }
}
