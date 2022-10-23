package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Instrument;
import com.sharkey.music.gigservice.repositories.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class InstrumentController {
    @Autowired
    InstrumentRepository instrumentRepository;

    @GetMapping(value = "/instruments")
    public ResponseEntity<List<Instrument>> getAllInstruments() {
        return new ResponseEntity<>(instrumentRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/instruments/{id}")
    public ResponseEntity<Instrument> getInstrument(@PathVariable Long id){
        return new ResponseEntity(instrumentRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/instruments")
    public ResponseEntity<Instrument> postInstrument(@RequestBody Instrument instrument){
        instrumentRepository.save(instrument);
        return new ResponseEntity<>(instrument, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/instruments/{id}")
    public ResponseEntity<Long> deleteInstrument(@PathVariable Long id){
        instrumentRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/instruments/{id}")
    public ResponseEntity<Instrument> putInstrument(@RequestBody Instrument instrument, @PathVariable Long id){
        Instrument foundInstrument = instrumentRepository.findById(id).get();
        foundInstrument.setName(instrument.getName());
        instrumentRepository.save(foundInstrument);
        return new ResponseEntity<>(foundInstrument, HttpStatus.OK);
    }

}
