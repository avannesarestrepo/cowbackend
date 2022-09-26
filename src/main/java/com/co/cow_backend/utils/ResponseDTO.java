package com.co.cow_backend.utils;

public class ResponseDTO {

    Constant constant;

    public Response setResponseSuccess(Object object){
        return new Response(constant.RESPONSE_SUCCESS(), object);
    }

    public Response setResponseFailed(String code, String exception){
        Error error = new Error(code, exception);
        return new Response(constant.RESPONSE_FAILED(), error);
    }
}
