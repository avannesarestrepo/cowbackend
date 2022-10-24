package com.co.cow_backend.controllers;

import com.co.cow_backend.models.Cow;
import com.co.cow_backend.models.CowGestation;
import com.co.cow_backend.service.CowGestationService;
import com.co.cow_backend.service.CowService;
import com.co.cow_backend.service.EventsService;
import com.co.cow_backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cow")
public class CowController {

    @Autowired
    CowService cowService;

    @Autowired
    CowGestationService cowGestationService;

    @Autowired
    EventsService eventsService;

    @GetMapping()
    public ResponseEntity<Object> getAllCow(){
        return new ResponseEntity<>(cowService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getByIdCow(@PathVariable("id") Integer id){
        return new ResponseEntity<>(cowService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Response> saveOrUpdate(@RequestBody Cow cow){
        Response cowResponse = cowService.saveOrUpdate(cow);
        if(!cowResponse.getStatus().equals("Failed")){
            Response cowGestation = cowGestationService.saveNewCow((Cow) cowResponse.getObject());
            eventsService.saveAllVacunas((Cow) cowResponse.getObject());
            eventsService.saveAll((CowGestation) cowGestation.getObject());
        }
        return new ResponseEntity<>(cowResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteCow(@PathVariable("id") Integer id){
        cowGestationService.delete(id);
        return new ResponseEntity<>(cowService.delete(id), HttpStatus.OK);
    }
}
