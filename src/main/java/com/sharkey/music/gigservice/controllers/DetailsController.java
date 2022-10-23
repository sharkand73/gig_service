package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Details;
import com.sharkey.music.gigservice.repositories.AddressRepository;
import com.sharkey.music.gigservice.repositories.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DetailsController {
    @Autowired
    DetailsRepository detailsRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping(value = "/details")
    public ResponseEntity<List<Details>> getAllDetailss() {
        return new ResponseEntity<>(detailsRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/details/count")
    public ResponseEntity<Long> getDetailsCount() {
        return new ResponseEntity<>(detailsRepository.count(), HttpStatus.OK);
    }

    @GetMapping(value = "/details/{id}")
    public ResponseEntity<Details> getDetails(@PathVariable Long id){
        return new ResponseEntity(detailsRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/details")
    public ResponseEntity<Details> postDetails(@RequestBody Details details){
        detailsRepository.save(details);
        return new ResponseEntity<>(details, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/details/batch")
    public ResponseEntity<List<Details>> postDetails(@RequestBody List<Details> details){
        detailsRepository.saveAll(details);
        return new ResponseEntity<>(details, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/details/{id}")
    public ResponseEntity<Long> deleteDetails(@PathVariable Long id){
        Details details = detailsRepository.findById(id).get();
        Address address = details.getAddress();
        detailsRepository.delete(details);
        addressRepository.delete(address);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/details/{id}")
    public ResponseEntity<Details> putDetails(@RequestBody Details details, @PathVariable Long id){
        Details foundDetails = detailsRepository.findById(id).get();
        Address address = details.getAddress();
        foundDetails.setAddress(address);
        foundDetails.setMobile(details.getMobile());
        foundDetails.setAltPhone(details.getAltPhone());
        foundDetails.setEmail(details.getEmail());
        foundDetails.setAltEmail(details.getAltEmail());
        addressRepository.save(address);
        detailsRepository.save(foundDetails);
        return new ResponseEntity<>(foundDetails, HttpStatus.OK);
    }
}
