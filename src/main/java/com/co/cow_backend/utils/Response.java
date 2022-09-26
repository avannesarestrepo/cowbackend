package com.co.cow_backend.utils;

public class Response {
    private String status;
    private Object classObject;

    public Response(String status, Object classObject) {
        this.status = status;
        this.classObject = classObject;
    }
}
