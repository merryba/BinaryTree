package com.merryba.login.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

      
    @ExceptionHandler(UserNotFoundException.class)
    public final  @ResponseBody  ResponseEntity<ErrorDetails> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
      ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
          request.getDescription(false));
      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    void handleBadRequests(HttpServletResponse response) throws Exception  {
        response.sendError(HttpStatus.BAD_REQUEST.value(), "Please try again and with a non empty string as 'name'");
    }
    
    @ExceptionHandler(InvalidFormatException.class)
    public final @ResponseBody ResponseEntity<Object> handleInvalidFormat(InvalidFormatException ex, WebRequest request){
    	ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
    	          request.getDescription(false));
    	      return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);

    }@ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void handleConflict() {
    }

    
    
}




