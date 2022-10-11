package com.co.cow_backend.repository;

import com.co.cow_backend.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {

    @Query(value = "SELECT A.ID_NOTIFICATION, A.ID_VACA, A.NOMBRE_EVENTO, A.FECHA_EVENTO, A.ESTADO " +
            "FROM EVENTS A WHERE :fechaEvento", nativeQuery = true)
    List<Events> getByDate(String fechaEvento);
}
