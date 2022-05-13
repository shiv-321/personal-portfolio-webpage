package com.personal.portfolio.shivaraj.exception;

import lombok.Getter;

public class ServiceNotFoundException extends RuntimeException{

    @Getter
    private int statusCode;
    private String message;

    public ServiceNotFoundException(int statusCode, String message){
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

}
