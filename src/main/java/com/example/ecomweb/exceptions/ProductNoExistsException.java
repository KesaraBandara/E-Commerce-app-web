package com.example.ecomweb.exceptions;

public class ProductNoExistsException extends IllegalArgumentException {
    public ProductNoExistsException(String message) {
        super(message);
    }
}
