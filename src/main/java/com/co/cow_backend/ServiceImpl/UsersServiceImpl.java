package com.co.cow_backend.ServiceImpl;

import com.co.cow_backend.models.Users;
import com.co.cow_backend.repository.UsersRepository;
import com.co.cow_backend.service.UsersService;
import com.co.cow_backend.utils.Constant;
import com.co.cow_backend.utils.Response;
import com.co.cow_backend.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersServiceImpl implements UsersService {

    Constant constant;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Response findById(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Users user = usersRepository.findById(id).get();
            return responseDTO.setResponseSuccess(user);
        }catch (NoSuchElementException e){
            return responseDTO.setResponseFailed(constant.CODE_NOT_FOUND(),
                    constant.MESSAGE_NOT_VALUE_PRESENT());
        }
    }

    @Transactional
    @Override
    public Users saveOrUpdate(Users users) {
        return usersRepository.save(users);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }
}
