package com.example.demo.entity;

import com.example.demo.entity.enumeration.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends BaseEntity {

    private String fullName;
    private LocalDate birthDate;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany
    List<Course> courseList;

}
