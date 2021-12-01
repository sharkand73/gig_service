package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressRepository addressRepository;

    @GetMapping(value = "/addresses")
    public List<Address> getAllAddresss() {return addressRepository.findAll();}

    @GetMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable Long id){
        return new ResponseEntity(addressRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/addresses")
    public ResponseEntity<Address> postAddress(@RequestBody Address address){
        addressRepository.save(address);
        return new ResponseEntity<>(address, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/addresses/{id}")
    public ResponseEntity<Long> deleteAddress(@PathVariable Long id){
        addressRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> putAddress(@RequestBody Address address, @PathVariable Long id){
        Address foundAddress = addressRepository.findById(id).get();
        foundAddress.setAddressLine1(address.getAddressLine1());
        foundAddress.setAddressLine2(address.getAddressLine2());
        foundAddress.setCity(address.getCity());
        foundAddress.setRegion(address.getRegion());
        foundAddress.setPostcode(address.getPostcode());
        foundAddress.setCountry(address.getCountry());
        addressRepository.save(foundAddress);
        return new ResponseEntity<>(foundAddress, HttpStatus.OK);
    }
}
