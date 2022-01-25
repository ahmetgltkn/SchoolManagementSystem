package com.example.demo.dto;


import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class PermamentInstructor extends InstructorDTO{

    private double fixedSalary;

}
