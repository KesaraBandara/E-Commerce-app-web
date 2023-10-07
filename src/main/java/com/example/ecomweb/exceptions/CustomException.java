package com.example.ecomweb.exceptions;


public class CustomException extends IllegalStateException {
    public CustomException(String message){
        super(message);
    }
}
