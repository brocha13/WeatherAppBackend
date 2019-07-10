package com.example.Pogoda.exceptions;

public class UserExistsException extends RuntimeException {

    public UserExistsException(){
        super("User already exists");
    }
}
