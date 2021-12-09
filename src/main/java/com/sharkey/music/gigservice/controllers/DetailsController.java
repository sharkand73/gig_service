package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Details;
import com.sharkey.music.gigservice.repositories.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DetailsController {
    @Autowired
    DetailsRepository detailsRepository;

    @GetMapping(value = "/details")
    public List<Details> getAllDetailss() {return detailsRepository.findAll();}

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
        for(Details detailsItem : details) {
            detailsRepository.save(detailsItem);
        }
        return new ResponseEntity<>(details, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/details/{id}")
    public ResponseEntity<Long> deleteDetails(@PathVariable Long id){
        detailsRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/details/{id}")
    public ResponseEntity<Details> putDetails(@RequestBody Details details, @PathVariable Long id){
        Details foundDetails = detailsRepository.findById(id).get();
        foundDetails.setAddress(details.getAddress());
        foundDetails.setMobile(details.getMobile());
        foundDetails.setAltPhone(details.getAltPhone());
        foundDetails.setEmail(details.getEmail());
        foundDetails.setAltEmail(details.getAltEmail());
        detailsRepository.save(foundDetails);
        return new ResponseEntity<>(foundDetails, HttpStatus.OK);
    }
}
