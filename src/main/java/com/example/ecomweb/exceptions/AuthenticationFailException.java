package com.example.ecomweb.exceptions;

public class AuthenticationFailException extends IllegalArgumentException {
    public AuthenticationFailException(String message){
        super(message);
    }
}
