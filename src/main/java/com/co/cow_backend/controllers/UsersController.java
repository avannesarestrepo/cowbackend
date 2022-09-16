package com.co.cow_backend.controllers;

import com.co.cow_backend.models.Users;
import com.co.cow_backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping()
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Object> saveOrUpdate(@RequestBody Users users){
        return new ResponseEntity<>(usersService.saveOrUpdate(users), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        usersService.delete(id);
    }
}
