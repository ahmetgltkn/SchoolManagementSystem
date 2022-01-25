package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Course extends BaseEntity {

    private String courseName;
    private int courseCode;
    private double creditScore;

    @ManyToOne
    Instructor instructor;


    @ManyToMany
    List<Student> studentList ;

}
