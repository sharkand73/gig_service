package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Details;
import com.sharkey.music.gigservice.models.Person;
import com.sharkey.music.gigservice.repositories.AddressRepository;
import com.sharkey.music.gigservice.repositories.DetailsRepository;
import com.sharkey.music.gigservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    DetailsRepository detailsRepository;
    @Autowired
    AddressRepository addressRepository;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/persons/count")
    public ResponseEntity<Long> getPersonsCount(){
        return new ResponseEntity<Long>(personRepository.count(), HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Person> getUser(@PathVariable Long id){
        return new ResponseEntity(personRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> postUser(@RequestBody Person person){
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/persons/full")
    public ResponseEntity<Person> postUserFull(@RequestBody Person person){
        Details details = person.getDetails();
        Address address = details.getAddress();
        addressRepository.save(address);
        details.setAddress(address);
        detailsRepository.save(details);
        person.setDetails(details);
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/persons/batch")
    public ResponseEntity<List<Person>> postPersons(@RequestBody List<Person> persons){
        personRepository.saveAll(persons);
        return new ResponseEntity<>(persons, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/persons/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        Person person = personRepository.findById(id).get();
        if (person.getGroupsBooked().size() > 0){
            return new ResponseEntity<>("Unable to delete person because they have bookings", HttpStatus.LOCKED);
        }
        Details details = person.getDetails();
        Address address = details.getAddress();
        personRepository.delete(person);
        detailsRepository.delete(details);
        addressRepository.delete(address);
        String message = String.format("Person with id %d deleted\nDetails with id %d deleted\nAddress with id %d deleted", id, details.getId(), address.getId());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/persons/{id}")
    public ResponseEntity<Person> putPerson(@RequestBody Person person, @PathVariable Long id){
        Person foundPerson = personRepository.findById(id).get();
        foundPerson.setFirstName(person.getFirstName());
        foundPerson.setLastName(person.getLastName());
        Details details = person.getDetails();
        Address address = details.getAddress();
        foundPerson.setDetails(details);
        foundPerson.setOrganisation(person.getOrganisation());
        foundPerson.setInstruments(person.getInstruments());
        addressRepository.save(address);
        detailsRepository.save(details);
        personRepository.save(foundPerson);
        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }

}
