package com.co.cow_backend.controllers;

import com.co.cow_backend.models.Users;
import com.co.cow_backend.service.UsersService;
import com.co.cow_backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping()
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getByIdUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(usersService.findById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Response> saveOrUpdate(@RequestBody Users users){
        return new ResponseEntity<>(usersService.saveOrUpdate(users), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Integer id){
        return new ResponseEntity<>(usersService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Response> login(@RequestParam("user") Integer user, @RequestParam("password") String password){
        return new ResponseEntity<>(usersService.login(user, password), HttpStatus.OK);
    }
}
