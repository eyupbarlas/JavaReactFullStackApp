package com.backend.javabackend.exception;

public class UserNotFoundException extends RuntimeException{
    // TODO: To be called from UserController class -> method
    public UserNotFoundException(String id){
        super("Could not found the user with id " + id);
    }
}
