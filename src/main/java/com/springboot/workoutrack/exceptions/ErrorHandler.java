package com.springboot.workoutrack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler({SetNotFoundException.class, ExerciseNotFoundException.class})
    public ResponseEntity<ApiErrorObject> handleSetNotFoundException(SetNotFoundException ex, WebRequest request) {
        ApiErrorObject apiErrorObject = new ApiErrorObject();
        apiErrorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiErrorObject.setMessage(ex.getMessage());
        apiErrorObject.setTimeStamp(new Date());
        return new ResponseEntity<ApiErrorObject>(apiErrorObject, HttpStatus.NOT_FOUND);
    }
}
