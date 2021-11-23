package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Person;
import com.sharkey.music.gigservice.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/people")
    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }

}
