package com.spring.cruddemo.cruddemo.rest;

import com.spring.cruddemo.cruddemo.entity.Student;
import com.spring.cruddemo.cruddemo.exception.StudentErrorResponse;
import com.spring.cruddemo.cruddemo.exception.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentRestController {
    List<Student> theStudents;
    @PostConstruct
    public List<Student> LoadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("dhina","viswa","dhina4u@gmail.com"));
        theStudents.add(new Student("gayu","moorthi","gayumoorthi@gmail.com"));
        theStudents.add(new Student("dhiya","dhina","dhiyadgdg@gmail.com"));
        theStudents.add(new Student("gisha","dhina","gishadgdg@gmail.com"));

        return theStudents;
    }

    @GetMapping("/students/{id}")
        public Student getStudents(@PathVariable int id){
            if(id>=theStudents.size() || id<0){
                throw new StudentException("Given id is not within the range:"+id);
            }
            return theStudents.get(id);
        }

        //You may move the below exception handler to StudentResteExceptionHandler
        //This will provide AOP Practice using @ControllerAdvice
        //Generic global Exception Handler
        /*@ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(StudentException se){
        StudentErrorResponse response = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),se.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler
        public ResponseEntity<StudentErrorResponse> handleException(Exception se){
        StudentErrorResponse response = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(),se.getMessage(),System.currentTimeMillis());
        System.err.println("Bad Request called");
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }*/
    }

