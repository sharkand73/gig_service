package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Booking;
import com.sharkey.music.gigservice.models.Gig;
import com.sharkey.music.gigservice.repositories.GigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GigController {
    @Autowired
    GigRepository gigRepository;

    @GetMapping(value = "/gigs")
    public List<Gig> getAllGigs() {return gigRepository.findAll();}

    @GetMapping(value = "/gigs/{id}")
    public ResponseEntity<Gig> getGig(@PathVariable Long id){
        return new ResponseEntity(gigRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/gigs")
    public ResponseEntity<Gig> postGig(@RequestBody Gig gig){
        gigRepository.save(gig);
        return new ResponseEntity<>(gig, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/gigs/batch")
    public ResponseEntity<List<Gig>> postGigs(@RequestBody List<Gig> gigs) {
        for (Gig gig : gigs) {
            gigRepository.save(gig);
        }
        return new ResponseEntity<>(gigs, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/gigs/{id}")
    public ResponseEntity<Long> deleteGig(@PathVariable Long id){
        gigRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/gigs/{id}")
    public ResponseEntity<Gig> putGig(@RequestBody Gig gig, @PathVariable Long id){
        Gig foundGig = gigRepository.findById(id).get();
        foundGig.setBooking(gig.getBooking());
        foundGig.setAct(gig.getAct());
        foundGig.setArrivalTime(gig.getArrivalTime());
        foundGig.setStartTime(gig.getStartTime());
        foundGig.setEndTime(gig.getEndTime());
        foundGig.setPlayingTime(gig.getPlayingTime());
        foundGig.setVenue(gig.getVenue());
        foundGig.setGigType(gig.getGigType());
        foundGig.setDressCode(gig.getDressCode());
        foundGig.setSoundCheck(gig.isSoundCheck());
        foundGig.setFoodProvided(gig.isFoodProvided());
        foundGig.setDistanceDriven(gig.getDistanceDriven());
        foundGig.setMoneySpent(gig.getMoneySpent());
        gigRepository.save(foundGig);
        return new ResponseEntity<>(foundGig, HttpStatus.OK);
    }
}
