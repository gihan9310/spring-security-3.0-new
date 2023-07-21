package com.gihanz.advice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BandRequest400Exception extends RuntimeException{

    public BandRequest400Exception(String message) {
        super(message);
    }

    public HttpStatus getExceptionType(){
        return HttpStatus.BAD_REQUEST;
    }
}
