package com.example.demo.entity;

import com.example.demo.entity.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends BaseEntity {

    private String fullName;
    private String birthDate;
    private String address;
    private Gender gender;

    @ManyToMany
    List<Course> courseList;

}
