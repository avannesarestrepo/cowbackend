package com.co.cow_backend.utils;

public class Response {
    private String status;
    private Object object;

    public Response(String status, Object object) {
        this.status = status;
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
