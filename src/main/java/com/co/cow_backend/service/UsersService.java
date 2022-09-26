package com.co.cow_backend.service;

import com.co.cow_backend.models.Users;
import com.co.cow_backend.utils.Response;

import java.util.List;

public interface UsersService {
    List<Users> findAll();
    Response findById(Integer id);
    Users saveOrUpdate(Users users);
    void delete(Integer id);
}
