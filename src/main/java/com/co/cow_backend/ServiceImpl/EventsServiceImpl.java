package com.co.cow_backend.ServiceImpl;

import com.co.cow_backend.models.Cow;
import com.co.cow_backend.models.CowGestation;
import com.co.cow_backend.models.Events;
import com.co.cow_backend.repository.EventsRepository;
import com.co.cow_backend.service.EventsService;
import com.co.cow_backend.utils.Constant;
import com.co.cow_backend.utils.EventsDTO;
import com.co.cow_backend.utils.Response;
import com.co.cow_backend.utils.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    Constant constant;

    @Override
    public List<Events> findByDate() {
        SimpleDateFormat smf = new SimpleDateFormat("yyyy-MM-dd");
        String date = smf.format(new Date());
        return eventsRepository.getByDate(date);
    }

    @Override
    public Response saveAll(CowGestation cowGestation) {
        ResponseDTO responseDTO = new ResponseDTO();
        try {
            List<Events> listEvents = eventsRepository.saveAll(registerEvents(cowGestation));
            return responseDTO.setResponseSuccess(listEvents);
        }catch (Exception e){
            return responseDTO.setResponseFailed(constant.CODE_INTERNAL_ERROR_SERVER(), "Error generico");
        }
    }

    private List<Events> registerEvents(CowGestation cowGestation){
        List<Events> eventsAll = new ArrayList<>();
        eventsAll.add(new Events(cowGestation.getIdVaca(), "Fecha Celo", cowGestation.getFechaCelo(), false));
        eventsAll.add(new Events(cowGestation.getIdVaca(), "Fecha Inseminación", cowGestation.getFechaInseminacion(), false));
        eventsAll.add(new Events(cowGestation.getIdVaca(), "Fecha Secado", cowGestation.getFechaSecado(), false));
        eventsAll.add(new Events(cowGestation.getIdVaca(), "Fecha Parto", cowGestation.getFechaParto(), false));
        return eventsAll;
    }
}
