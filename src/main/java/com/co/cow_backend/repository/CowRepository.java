package com.co.cow_backend.repository;

import com.co.cow_backend.models.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CowRepository extends JpaRepository<Integer, Cow> {
}
