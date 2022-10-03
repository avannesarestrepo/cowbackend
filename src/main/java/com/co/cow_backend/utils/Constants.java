package com.co.cow_backend.utils;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Constants {
    private final String MESSAGE_NOT_VALUE_PRESENT = "La información solicitada no ha sido encontrada ";
    private final String MESSAGE_DELETE_NO_EXIST_ID = "La información a eliminar no ha sido encontrada ";
    private final String CODE_NOT_FOUND = "404";

    private final String CODE_FIELD_NULL = "409";

    public String MESSAGE_NOT_VALUE_PRESENT() {
        return MESSAGE_NOT_VALUE_PRESENT;
    }

    public String MESSAGE_DELETE_NO_EXIST_ID() {
        return MESSAGE_DELETE_NO_EXIST_ID;
    }

    public String CODE_NOT_FOUND() {
        return CODE_NOT_FOUND;
    }

    public String CODE_FIELD_NULL() {
        return CODE_FIELD_NULL;
    }
}
