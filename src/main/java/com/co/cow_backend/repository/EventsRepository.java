package com.co.cow_backend.repository;

import com.co.cow_backend.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {

    @Query(value = "SELECT ID_NOTIFICATION, ID_VACA, NOMBRE_EVENTO, FECHA_EVENTO, ESTADO FROM EVENTS WHERE FECHA_EVENTO = :fechaEvento", nativeQuery = true)
    List<Events> getByDate(String fechaEvento);
}
