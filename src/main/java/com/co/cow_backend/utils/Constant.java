package com.co.cow_backend.utils;

public class Constant {

    private final String RESPONSE_SUCCESS = "Success";
    private final String RESPONSE_FAILED = "Failed";
    private final String MESSAGE_NOT_VALUE_PRESENT = "El dato solicitado no ha sido encontrado";
    private final String CODE_NOT_FOUND = "404";

    public String RESPONSE_SUCCESS() {
        return RESPONSE_SUCCESS;
    }

    public String RESPONSE_FAILED() {
        return RESPONSE_FAILED;
    }

    public String MESSAGE_NOT_VALUE_PRESENT() {
        return MESSAGE_NOT_VALUE_PRESENT;
    }

    public String CODE_NOT_FOUND() {
        return CODE_NOT_FOUND;
    }
}
