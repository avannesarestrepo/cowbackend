package com.co.cow_backend.ServiceImpl;

import com.co.cow_backend.models.Users;
import com.co.cow_backend.repository.UsersRepository;
import com.co.cow_backend.service.UsersService;
import com.co.cow_backend.utils.Constant;
import com.co.cow_backend.utils.Response;
import com.co.cow_backend.utils.ResponseDTO;
import org.hibernate.DuplicateMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    Constant constant;
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll(Sort.by(Sort.Order.asc("id")));
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

    //@Transactional
    @Override
    public Response saveOrUpdate(Users users) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            Predicate<Users> userExist = user -> usersRepository.existByNumeroDocumento(user.getNumeroDocumento()) > 0;

            if(userExist.test(users)){
                return responseDTO.setResponseFailed(constant.CODE_CONFLICT(), constant.MESSAGE_CONFLICT_DUPLICATE());
            }

            Users usersResponse =  usersRepository.save(users);
            return responseDTO.setResponseSuccess(usersResponse);
        }catch (DataIntegrityViolationException e){
            return responseDTO.setResponseFailed(constant.CODE_INTERNAL_ERROR_SERVER(),
                    constant.MESSAGE_DATA_INTEGRATY_VIOLATION());
        }

    }

    @Transactional
    @Override
    public Response delete(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();

        Predicate<Integer> userExist = user -> usersRepository.existsById(id);

        if(userExist.test(id)){
            usersRepository.deleteById(id);
            return responseDTO.setResponseSuccess(new String("El usuario " + id + " fue eliminado correctamente"));
        }

        return responseDTO.setResponseFailed(constant.CODE_NOT_FOUND(), constant.MESSAGE_NOT_VALUE_PRESENT());
    }

    @Override
    public Response login(Integer user, String password){
        ResponseDTO responseDTO = new ResponseDTO();

        if(usersRepository.loginSucess(user, password) > 0){
            return responseDTO.setResponseSuccess(new String("Inicio de sesión existoso"));
        }

        return responseDTO.setResponseFailed(constant.CODE_NOT_FOUND(), constant.MESSAGE_LOGIN_FAILD());
    }
}
