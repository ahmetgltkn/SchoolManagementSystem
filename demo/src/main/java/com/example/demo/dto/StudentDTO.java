package com.example.demo.dto;


import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends BaseEntity {

    private long id;
    private String fullName;
    private LocalDate birthDate;
    private String address;
    private Gender gender;

}
