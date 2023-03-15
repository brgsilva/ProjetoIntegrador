package com.generation.melihealth.service.exceptions;

public class ResponseStatusException extends RuntimeException{

    public ResponseStatusException(String message) {
        super(message);
    }
}
