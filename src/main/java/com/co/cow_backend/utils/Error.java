package com.co.cow_backend.utils;

public class Error {
    private String code;
    private String exception;

    public Error(String code, String exception) {
        this.code = code;
        this.exception = exception;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}
