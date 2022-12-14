package com.co.cow_backend.repository;

import com.co.cow_backend.models.Cow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CowRepository extends JpaRepository<Cow, Integer> {
    @Query(value = "SELECT COUNT(ID_VACA) FROM COW WHERE NOMBRE = :nombre", nativeQuery = true)
    Integer existByName(String nombre);
}
