package com.co.cow_backend.service;

import com.co.cow_backend.models.Cow;
import com.co.cow_backend.utils.Response;

public interface CowGestationService {
    Response saveNewCow(Cow cow);
}
