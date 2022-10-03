package com.co.cow_backend.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Constant {
    private final String MESSAGE_NOT_VALUE_PRESENT = "El dato solicitado no ha sido encontrado";
    private final String MESSAGE_LOGIN_FAILD = "Inicio de sesión no exitoso";
    private final String MESSAGE_DATA_INTEGRATY_VIOLATION = "Información obligatoria incompleta en el JSON";
    private final String MESSAGE_CONFLICT_DUPLICATE = "Información duplicada";
    private final String CODE_NOT_FOUND = "404";
    private final String CODE_CONFLICT = "409";
    private final String CODE_INTERNAL_ERROR_SERVER = "500";


    public String MESSAGE_NOT_VALUE_PRESENT() {
        return MESSAGE_NOT_VALUE_PRESENT;
    }

    public String MESSAGE_LOGIN_FAILD() { return MESSAGE_LOGIN_FAILD; }

    public String MESSAGE_DATA_INTEGRATY_VIOLATION() {
        return MESSAGE_DATA_INTEGRATY_VIOLATION;
    }

    public String MESSAGE_CONFLICT_DUPLICATE() {
        return MESSAGE_CONFLICT_DUPLICATE;
    }

    public String CODE_NOT_FOUND() {
        return CODE_NOT_FOUND;
    }

    public String CODE_CONFLICT() {
        return CODE_CONFLICT;
    }

    public String CODE_INTERNAL_ERROR_SERVER() {
        return CODE_INTERNAL_ERROR_SERVER;
    }
}
