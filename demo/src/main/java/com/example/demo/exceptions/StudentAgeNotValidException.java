package com.example.demo.exceptions;

public class StudentAgeNotValidException extends RuntimeException{

    public StudentAgeNotValidException(String message) {
        super(message);
    }
}
