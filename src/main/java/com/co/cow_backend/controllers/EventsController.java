package com.co.cow_backend.controllers;

import com.co.cow_backend.models.Events;
import com.co.cow_backend.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/events")
public class EventsController {

    @Autowired
    EventsService eventsService;

    @GetMapping()
    public ResponseEntity<List<Events>> getByDate(){
        return new ResponseEntity<>(eventsService.findByDate(), HttpStatus.OK);
    }
}
