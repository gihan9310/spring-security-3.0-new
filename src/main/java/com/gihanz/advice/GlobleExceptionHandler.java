package com.gihanz.advice;


import com.gihanz.advice.exceptions.AuthException;
import com.gihanz.advice.exceptions.BandRequest400Exception;
import com.gihanz.advice.exceptions.RegistrationException;
import com.gihanz.advice.exceptions.UserNotFound401Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobleExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<SystemExceptionResponse> handleProjectObjectException(AuthException exception , WebRequest request){
        SystemExceptionResponse response = new SystemExceptionResponse(exception.getMessage());
        return  new ResponseEntity<>(response,exception.getExceptionType());
    }

    @ExceptionHandler
    public final ResponseEntity<SystemExceptionResponse> handleProjectObjectException(RegistrationException exception , WebRequest request){
        SystemExceptionResponse response = new SystemExceptionResponse(exception.getMessage());
        return  new ResponseEntity<>(response,exception.getExceptionType());
    }

    @ExceptionHandler
    public final ResponseEntity<SystemExceptionResponse> handleProjectObjectException(UserNotFound401Exception exception , WebRequest request){
        SystemExceptionResponse response = new SystemExceptionResponse(exception.getMessage());
        return  new ResponseEntity<>(response,exception.getExceptionType());
    }

    @ExceptionHandler
    public final ResponseEntity<SystemExceptionResponse> handleProjectObjectException(BandRequest400Exception exception , WebRequest request){
        SystemExceptionResponse response = new SystemExceptionResponse(exception.getMessage());
        return  new ResponseEntity<>(response,exception.getExceptionType());
    }

}
