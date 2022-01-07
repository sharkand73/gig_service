package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Act;
import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Gig;
import com.sharkey.music.gigservice.models.Venue;
import com.sharkey.music.gigservice.repositories.ActRepository;
import com.sharkey.music.gigservice.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VenueController {
    @Autowired
    VenueRepository venueRepository;

    @GetMapping(value = "/venues")
    public List<Venue> getAllVenues() {return venueRepository.findAll();}

    @GetMapping(value = "/venues/{id}")
    public ResponseEntity<Venue> getVenue(@PathVariable Long id){
        return new ResponseEntity(venueRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/venues/batch")
    public ResponseEntity<List<Venue>> postVenues(@RequestBody List<Venue> venues){
        for(Venue venue : venues) {
            venueRepository.save(venue);
        }
        return new ResponseEntity<>(venues, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/venues")
    public ResponseEntity<Venue> postVenue(@RequestBody Venue venue){
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/venues/{id}")
    public ResponseEntity<Long> deleteVenue(@PathVariable Long id){
        venueRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/venues/{id}")
    public ResponseEntity<Venue> putVenue(@RequestBody Venue venue, @PathVariable Long id){
        Venue foundVenue = venueRepository.findById(id).get();
        foundVenue.setName(venue.getName());
        foundVenue.setAddress(venue.getAddress());
        foundVenue.setCoordinatesN(venue.getCoordinatesN());
        foundVenue.setCoordinatesW(venue.getCoordinatesW());
        foundVenue.setVenueType(venue.getVenueType());
        venueRepository.save(foundVenue);
        return new ResponseEntity<>(foundVenue, HttpStatus.OK);
    }
}
