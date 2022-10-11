package com.co.cow_backend.service;

import com.co.cow_backend.models.CowGestation;
import com.co.cow_backend.models.Events;
import com.co.cow_backend.utils.Response;

import java.util.List;

public interface EventsService {
    List<Events> findByDate();
    Response saveAll(CowGestation cowGestation);

    Response update(Events events);
}
