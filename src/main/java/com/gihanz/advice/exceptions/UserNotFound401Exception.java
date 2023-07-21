package com.gihanz.advice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserNotFound401Exception extends UsernameNotFoundException {
    public UserNotFound401Exception(String msg) {
        super(msg);
    }

    public HttpStatus getExceptionType(){
        return HttpStatus.UNAUTHORIZED;
    }
}
