package com.co.cow_backend.controllers;

import com.co.cow_backend.models.CowGestation;
import com.co.cow_backend.service.CowGestationService;
import com.co.cow_backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cowgestation")
public class CowGestationController {

    @Autowired
    CowGestationService cowGestationService;

    @GetMapping("/{id}")
    public ResponseEntity<Response> getByIdCowGestation(@PathVariable("id") Integer id){
        return new ResponseEntity<>(cowGestationService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Response> saveCowGestation(@RequestBody CowGestation cowGestation){
        return new ResponseEntity<>(cowGestationService.save(cowGestation), HttpStatus.OK);
    }
}
