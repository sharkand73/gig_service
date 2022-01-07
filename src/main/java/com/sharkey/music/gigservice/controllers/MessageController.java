package com.sharkey.music.gigservice.controllers;

import com.sharkey.music.gigservice.models.Address;
import com.sharkey.music.gigservice.models.Message;
import com.sharkey.music.gigservice.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping(value = "/messages")
    public List<Message> getAllMessages() {return messageRepository.findAll();}

    @GetMapping(value = "/messages/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id){
        return new ResponseEntity(messageRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/messages")
    public ResponseEntity<Message> postMessage(@RequestBody Message message){
        messageRepository.save(message);
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/messages/batch")
    public ResponseEntity<List<Message>> postMessages(@RequestBody List<Message> messages){
        for(Message message : messages) {
            messageRepository.save(message);
        }
        return new ResponseEntity<>(messages, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/messages/{id}")
    public ResponseEntity<Long> deleteMessage(@PathVariable Long id){
        messageRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/messages/{id}")
    public ResponseEntity<Message> putMessage(@RequestBody Message message, @PathVariable Long id){
        Message foundMessage = messageRepository.findById(id).get();
        foundMessage.setDate(message.getDate());
        foundMessage.setBody(message.getBody());
        messageRepository.save(foundMessage);
        return new ResponseEntity<>(foundMessage, HttpStatus.OK);
    }

}
