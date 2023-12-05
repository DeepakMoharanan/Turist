package com.WanderHub.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlaseNotFoundException extends RuntimeException {
    public PlaseNotFoundException(String message) {
        super(message);
    }
}

