package com.springboot.workoutrack.exceptions;

public class SetNotFoundException extends RuntimeException {
    public SetNotFoundException(String message) {
        super(message);
    }
}
