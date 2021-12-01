package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Gig;
import com.sharkey.music.gigservice.models.Person;
import com.sharkey.music.gigservice.models.Venue;
import com.sharkey.music.gigservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/people")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
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

    @DeleteMapping(value = "/persons/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id){
        personRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/persons/{id}")
    public ResponseEntity<Person> putPerson(@RequestBody Person person, @PathVariable Long id){
        Person foundPerson = personRepository.findById(id).get();
        foundPerson.setFirstName(person.getFirstName());
        foundPerson.setLastName(person.getLastName());
        foundPerson.setDetails(person.getDetails());
        foundPerson.setOrganisation(person.getOrganisation());
        foundPerson.setInstruments(person.getInstruments());
        personRepository.save(foundPerson);
        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }

}
