package com.co.cow_backend.ServiceImpl;

import com.co.cow_backend.models.Cow;
import com.co.cow_backend.models.CowGestation;
import com.co.cow_backend.repository.CowGestationRepository;
import com.co.cow_backend.service.CowGestationService;
import com.co.cow_backend.utils.Response;
import com.co.cow_backend.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CowGestationServiceImpl implements CowGestationService {

    @Autowired
    CowGestationRepository cowGestationRepository;

    @Override
    public Response findById(Integer idVaca) {
        ResponseDTO responseDTO = new ResponseDTO();
        CowGestation cowGestation = cowGestationRepository.findByIdVaca(idVaca);
        return responseDTO.setResponseSuccess(cowGestation);
    }

    @Override
    public void delete(Integer idVaca) {
        CowGestation cowGestationVerify = cowGestationRepository.findByIdVaca(idVaca);
        Integer idProcesoGestacionVaca = cowGestationVerify.getIdProcesoGestacionVaca();
        if(cowGestationVerify.getIdProcesoGestacionVaca() != null){
            cowGestationRepository.deleteById(idProcesoGestacionVaca);
        }
    }

    @Override
    public Response saveNewCow(Cow cow) {
        ResponseDTO responseDTO = new ResponseDTO();
        CowGestation cowGestation = new CowGestation();

        CowGestation cowGestationVerify = cowGestationRepository.findByIdVaca(cow.getIdVaca());
        if(cowGestationVerify != null){
            cowGestation.setIdProcesoGestacionVaca(cowGestationVerify.getIdProcesoGestacionVaca());
        }

        cowGestation.setIdVaca(cow.getIdVaca());
        cowGestation.setFechaCelo(calculateDate(cow.getFechaNacimiento(), 15, false));
        cowGestation.setFechaInseminacion(cowGestation.getFechaCelo());
        cowGestation.setFechaSecado(calculateDate(cowGestation.getFechaInseminacion(), 7, false));
        cowGestation.setFechaParto(calculateDate(cowGestation.getFechaSecado(), 60, true));

        cowGestationRepository.save(cowGestation);
        return responseDTO.setResponseSuccess(cowGestation);
    }

    @Override
    public Response save(CowGestation cowGestation) {
        ResponseDTO responseDTO = new ResponseDTO();
        CowGestation cowGestationResponse = cowGestationRepository.save(cowGestation);
        return responseDTO.setResponseSuccess(cowGestationResponse);
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
