package com.co.cow_backend.ServiceImpl;

import com.co.cow_backend.models.Cow;
import com.co.cow_backend.models.Users;
import com.co.cow_backend.repository.CowRepository;
import com.co.cow_backend.service.CowService;
import com.co.cow_backend.utils.Constant;
import com.co.cow_backend.utils.Response;
import com.co.cow_backend.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

@Service
public class CowServiceImpl implements CowService {

    @Autowired
    Constant constant;

    @Autowired
    CowRepository cowRepository;

    @Override
    public List<Cow> findAll() {
        return cowRepository.findAll(Sort.by(Sort.Order.asc("idVaca")));
    }

    @Override
    public Response findById(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        try{
            Cow cow = cowRepository.findById(id).get();
            return responseDTO.setResponseSuccess(cow);
        }catch (NoSuchElementException e){
            return responseDTO.setResponseFailed(constant.CODE_NOT_FOUND(),
                    constant.MESSAGE_NOT_VALUE_PRESENT());
        }
    }

    @Override
    public Response saveOrUpdate(Cow cow) {
        ResponseDTO responseDTO = new ResponseDTO();

        Predicate<Cow> cowExist = cows -> cowRepository.existByName(cows.getNombre().toLowerCase()) > 0;

        if(cow.getIdVaca() == null && cowExist.test(cow)){
            return responseDTO.setResponseFailed(constant.CODE_CONFLICT(), constant.MESSAGE_CONFLICT_DUPLICATE());
        }

        cow.setNombre(cow.getNombre().toLowerCase());
        if(cow.getIdVaca() == 0){
            cow.setFechaVacunaAftosa(calculateDate(cow.getFechaNacimiento(), 40, true));
            cow.setFechaVacunaBrucelosis(calculateDate(cow.getFechaNacimiento(), 3, false));
        }
        cow.setNumeroPartos(0);

        try {
            Cow cowResponse =  cowRepository.save(cow);
            return responseDTO.setResponseSuccess(cowResponse);
        }catch (DataIntegrityViolationException e){
            return responseDTO.setResponseFailed(constant.CODE_INTERNAL_ERROR_SERVER(),
                    constant.MESSAGE_DATA_INTEGRATY_VIOLATION());
        }
    }

    @Override
    public Response delete(Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();

        Predicate<Integer> cowExist = cow -> cowRepository.existsById(id);

        if(cowExist.test(id)){
            cowRepository.deleteById(id);
            return responseDTO.setResponseSuccess(new String("La vaca" + id + " fue eliminada correctamente"));
        }

        return responseDTO.setResponseFailed(constant.CODE_NOT_FOUND(), constant.MESSAGE_NOT_VALUE_PRESENT());
    }

    private LocalDate calculateDate(LocalDate date, int time, Boolean isDays){
        LocalDate result = date;
        int addTime =  0;
        while(addTime < time){
            if(isDays){
                result = result.plusDays(1);
            }else {
                result = result.plusMonths(1);
            }
            ++addTime;
        }

        return result;
    }
}
