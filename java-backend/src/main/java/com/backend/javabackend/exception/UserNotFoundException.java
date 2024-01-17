package com.backend.javabackend.exception;

public class UserNotFoundException extends RuntimeException{
    // TODO: To be called from UserController class -> method
    public UserNotFoundException(Long id){
        super("Could not found the user with id " + id);
    }
}
