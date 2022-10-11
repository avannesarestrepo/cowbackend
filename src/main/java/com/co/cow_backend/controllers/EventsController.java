package com.co.cow_backend.controllers;

import com.co.cow_backend.models.Events;
import com.co.cow_backend.service.EventsService;
import com.co.cow_backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity<Response> update(@RequestBody Events events){
        return new ResponseEntity<>(eventsService.update(events), HttpStatus.OK);
    }
}
