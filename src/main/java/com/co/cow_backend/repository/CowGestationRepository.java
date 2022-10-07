package com.co.cow_backend.repository;

import com.co.cow_backend.models.CowGestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CowGestationRepository extends JpaRepository<CowGestation, Integer> {
}
