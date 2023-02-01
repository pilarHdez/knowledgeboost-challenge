package com.globant.exercise.exception;

public class InvalidParameterException extends RuntimeException {
    private String message;

    public InvalidParameterException(String message) {
        super(message);
        this.message = message;
    }

    public InvalidParameterException() {
        super();
    }
}
