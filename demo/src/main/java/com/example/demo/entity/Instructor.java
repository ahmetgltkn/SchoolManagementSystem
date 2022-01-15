package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor extends BaseEntity{

    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor")
    List<Course> courseList;



}
