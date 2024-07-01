package com.spring.cruddemo.cruddemo.exception;

import com.spring.cruddemo.cruddemo.rest.StudentRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = StudentRestController.class)
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentException se){
        StudentErrorResponse response = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),se.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception se){
        StudentErrorResponse response = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),se.getMessage(),System.currentTimeMillis());
        System.err.println("Bad Request called from:"+this.getClass().getSimpleName());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
