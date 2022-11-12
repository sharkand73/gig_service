package com.sharkey.music.gigservice.controllers;


import com.sharkey.music.gigservice.models.Venue;
import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.repositories.VenueRepository;
import com.sharkey.music.gigservice.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class VenueController {
    @Autowired
    VenueRepository venueRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping(value = "/venues")
    public ResponseEntity<List<Venue>> getAllVenues() {
        return new ResponseEntity<>(venueRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/venues/count")
    public ResponseEntity<Long> getVenueCount() {
        return new ResponseEntity<Long>(venueRepository.count(), HttpStatus.OK);
    }

    @GetMapping(value = "/venues/{id}")
    public ResponseEntity<Venue> getVenue(@PathVariable Long id){
        return new ResponseEntity(venueRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/venues/batch")
    public ResponseEntity<List<Venue>> postVenues(@RequestBody List<Venue> venues){
        venueRepository.saveAll(venues);
        return new ResponseEntity<>(venues, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/venues")
    public ResponseEntity<Venue> postVenue(@RequestBody Venue venue){
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/venues/full")
    public ResponseEntity<Venue> postVenueFull(@RequestBody Venue venue){
        Address address = venue.getAddress();
        addressRepository.save(address);
        venue.setAddress(address);
        venueRepository.save(venue);
        return new ResponseEntity<>(venue, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/venues/{id}")
    public ResponseEntity<String> deleteVenue(@PathVariable Long id){
        Venue venue = venueRepository.findById(id).get();
        if (venue.getGigs().size() > 0){
            return new ResponseEntity<>("Cannot delete venue because it has gigs", HttpStatus.LOCKED);
        }
        Address address = venue.getAddress();
        venueRepository.delete(venue);
        addressRepository.delete(address);
        String message = String.format("Venue with id %d deleted\nAddress with id %d deleted", id, address.getId());
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/venues/{id}")
    public ResponseEntity<Venue> putVenue(@RequestBody Venue venue, @PathVariable Long id){
        Venue foundVenue = venueRepository.findById(id).get();
        foundVenue.setName(venue.getName());
        Address address = venue.getAddress();
        foundVenue.setAddress(address);
        foundVenue.setCoordinatesN(venue.getCoordinatesN());
        foundVenue.setCoordinatesE(venue.getCoordinatesE());
        foundVenue.setVenueType(venue.getVenueType());
        addressRepository.save(address);
        venueRepository.save(foundVenue);
        return new ResponseEntity<>(foundVenue, HttpStatus.OK);
    }
}
