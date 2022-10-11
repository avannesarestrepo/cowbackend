package com.co.cow_backend.repository;

import com.co.cow_backend.models.CowGestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CowGestationRepository extends JpaRepository<CowGestation, Integer> {

    @Query(value = "SELECT * FROM COW_GESTATION WHERE ID_VACA = :idVaca", nativeQuery = true)
    CowGestation findByIdVaca(Integer idVaca);
}
