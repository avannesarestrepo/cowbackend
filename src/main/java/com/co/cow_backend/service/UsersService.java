package com.co.cow_backend.service;

import com.co.cow_backend.models.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();
    Users findById(Integer id);
    Users saveOrUpdate(Users users);
    void delete(Integer id);
}
