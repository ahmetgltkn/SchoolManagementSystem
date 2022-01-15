package com.example.demo.util;

import com.example.demo.exceptions.BadRequestException;

public class StudentValidatorUtil {
    public static void validateStudentAge(int age){
        if(age<18 || age > 40)
            throw new BadRequestException("Student can't be younger than 18 and older than 40.");
    }
}
