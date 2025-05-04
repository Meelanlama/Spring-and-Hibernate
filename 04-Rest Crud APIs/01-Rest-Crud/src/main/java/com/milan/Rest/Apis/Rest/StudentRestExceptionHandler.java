package com.milan.Rest.Apis.Rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
    //Add an exception handler using @ExceptionHandler, Type of response body and exception type to handle
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        //create a studentErrorResponse
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity with the body amd status code(404)
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    //add another exception handler... to catch any type of exception(generic for handling alphabets:("acb")
    @ExceptionHandler ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        //create a studentErrorResponse
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("Bad request.. please enter a valid student id");
        errorResponse.setTimestamp(System.currentTimeMillis());

        //return ResponseEntity with the body amd status code(404)
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
