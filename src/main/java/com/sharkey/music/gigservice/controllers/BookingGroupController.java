package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.BookingGroup;
import com.sharkey.music.gigservice.models.Message;
import com.sharkey.music.gigservice.repositories.BookingGroupRepository;
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
    public ResponseEntity<List<BookingGroup>> getAllGroups() {
        return new ResponseEntity<>(bookingGroupRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/groups/count")
    public ResponseEntity<Long> getGroupCount() {
        return new ResponseEntity<>(bookingGroupRepository.count(), HttpStatus.OK);
    }

    @GetMapping(value = "/groups/active/count")
    public ResponseEntity<Long> getActiveGroupCount() {
        Long totalGroups = bookingGroupRepository.count();
        Long archivedGroups = (long) bookingGroupRepository.findBookingGroupByArchived(true).size();
        return new ResponseEntity<>(totalGroups - archivedGroups, HttpStatus.OK);
    }

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
        bookingGroupRepository.saveAll(groups);
        return new ResponseEntity<>(groups, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/groups/{id}")
    public ResponseEntity<String> deleteGroup(@PathVariable Long id){
        BookingGroup group = bookingGroupRepository.findById(id).get();
        if (group.getBookings().size() > 0){
            return new ResponseEntity<>("Cannot delete booking group because it has bookings", HttpStatus.LOCKED);
        }
        bookingGroupRepository.delete(group);
        return new ResponseEntity<>(id.toString(), HttpStatus.OK);
    }

    @PutMapping(value = "/groups/{id}")
    public ResponseEntity<BookingGroup> putGroup(@RequestBody BookingGroup bookingGroup, @PathVariable Long id){
        BookingGroup foundBookingGroup = bookingGroupRepository.findById(id).get();
        foundBookingGroup.setBooker(bookingGroup.getBooker());
        foundBookingGroup.setBookingDate(bookingGroup.getBookingDate());
        foundBookingGroup.setFeePaymentMethod(bookingGroup.getFeePaymentMethod());
        foundBookingGroup.setExpensesPaymentMethod(bookingGroup.getExpensesPaymentMethod());
        foundBookingGroup.setArchived(bookingGroup.isArchived());
        bookingGroupRepository.save(foundBookingGroup);
        return new ResponseEntity<>(foundBookingGroup, HttpStatus.OK);
    }
}
