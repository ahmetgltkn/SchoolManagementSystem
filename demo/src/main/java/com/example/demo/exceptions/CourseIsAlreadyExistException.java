package com.example.demo.exceptions;


public class CourseIsAlreadyExistException extends RuntimeException {

    public CourseIsAlreadyExistException(String message) {
        super(message);
    }
}
