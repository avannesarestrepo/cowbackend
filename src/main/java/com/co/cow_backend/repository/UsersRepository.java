package com.co.cow_backend.repository;

import com.co.cow_backend.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT COUNT(ID) FROM USERS WHERE NUMERO_DOCUMENTO = :numeroDocumento", nativeQuery = true)
    Integer existByNumeroDocumento(Integer numeroDocumento);

    @Query(value = "SELECT COUNT(ID) FROM USERS WHERE" +
            " NUMERO_DOCUMENTO = :numeroDocumento AND " +
            " CONTRASENA = :contrasena AND ESTADO = true", nativeQuery = true)
    Integer loginSucess(Integer numeroDocumento, String contrasena);
}

