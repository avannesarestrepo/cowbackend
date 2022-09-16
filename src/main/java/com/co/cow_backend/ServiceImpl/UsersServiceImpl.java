package com.co.cow_backend.ServiceImpl;

import com.co.cow_backend.models.Users;
import com.co.cow_backend.repository.UsersRepository;
import com.co.cow_backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(Integer id) {
        return usersRepository.findById(id).get();
    }

    @Override
    public Users saveOrUpdate(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }
}
