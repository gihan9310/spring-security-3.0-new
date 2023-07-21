package com.gihanz.advice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RegistrationException extends RuntimeException {

    public RegistrationException(String message) {
        super(message);
    }

    public HttpStatus getExceptionType(){
        return HttpStatus.BAD_REQUEST;
    }
}
