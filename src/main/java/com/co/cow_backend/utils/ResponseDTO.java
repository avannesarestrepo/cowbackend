package com.co.cow_backend.utils;


public class ResponseDTO {

    public Response setResponseSuccess(Object object){
        return new Response("Success", object);
    }

    public Response setResponseFailed(String code, String exception){
        Error error = new Error(code, exception);
        return new Response("Failed", error);
    }
}
