package com.evan.springbootmvcsecurityhibernatemysql.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super("Could not find the user with id " + id);
    }
}
