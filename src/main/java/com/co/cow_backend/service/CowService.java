package com.co.cow_backend.service;

import com.co.cow_backend.models.Cow;
import com.co.cow_backend.utils.Response;

import java.util.List;

public interface CowService {
    List<Cow> findAll();
    Response findById(Integer id);
    Response saveOrUpdate(Cow cow);
    Response delete(Integer id);
}
