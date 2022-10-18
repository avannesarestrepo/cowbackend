package com.co.cow_backend.service;

import com.co.cow_backend.models.Cow;
import com.co.cow_backend.models.CowGestation;
import com.co.cow_backend.utils.Response;

public interface CowGestationService {
    Response saveNewCow(Cow cow);
    Response save(CowGestation cowGestation);
    Response findById(Integer idVaca);
    void delete(Integer id);
}
