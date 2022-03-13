package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Act;
import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.repositories.ActRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActController {
    @Autowired
    ActRepository actRepository;

    @GetMapping(value = "/acts")
    public List<Act> getAllActs() {return actRepository.findAll();}

    @GetMapping(value = "/acts/{id}")
    public ResponseEntity<Act> getAct(@PathVariable Long id){
        return new ResponseEntity(actRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/acts/batch")
    public ResponseEntity<List<Act>> postActs(@RequestBody List<Act> acts){
        for(Act act : acts) {
            actRepository.save(act);
        }
        return new ResponseEntity<>(acts, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/acts")
    public ResponseEntity<Act> postAct(@RequestBody Act act){
        actRepository.save(act);
        return new ResponseEntity<>(act, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/acts/{id}")
    public ResponseEntity<Long> deleteAct(@PathVariable Long id){
        actRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/acts/{id}")
    public ResponseEntity<Act> putAct(@RequestBody Act act, @PathVariable Long id){
        Act foundAct = actRepository.findById(id).get();
        foundAct.setName(act.getName());
        foundAct.setStyles(act.getStyles());
        foundAct.setSkillsRequired(act.getSkillsRequired());
        foundAct.setPrepRequired(act.getPrepRequired());
        foundAct.setDefaultDressCode(act.getDefaultDressCode());
        actRepository.save(foundAct);
        return new ResponseEntity<>(foundAct, HttpStatus.OK);
    }
}
