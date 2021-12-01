package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Gig;
import com.sharkey.music.gigservice.repositories.GigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GigController {
    @Autowired
    GigRepository gigRepository;

    @GetMapping(value = "/gigs")
    public List<Gig> getAllGigs() {return gigRepository.findAll();}

    @GetMapping(value = "/gigs/{id}")
    public ResponseEntity<Gig> getUser(@PathVariable Long id){
        return new ResponseEntity(gigRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/gigs")
    public ResponseEntity<Gig> postUser(@RequestBody Gig gig){
        gigRepository.save(gig);
        return new ResponseEntity<>(gig, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/gigs/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
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
        foundGig.setIsRehearsal(gig.getIsRehearsal());
        foundGig.setDressCode(gig.getDressCode());
        foundGig.setSoundCheck(gig.getSoundCheck());
        foundGig.setFoodProvided(gig.getFoodProvided());
        foundGig.setDistanceDriven(gig.getDistanceDriven());
        foundGig.setMoneySpent(gig.getMoneySpent());
        gigRepository.save(foundGig);
        return new ResponseEntity<>(foundGig, HttpStatus.OK);
    }
}
