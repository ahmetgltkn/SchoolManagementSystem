package com.example.demo.dto;


import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.enumeration.Gender;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends BaseEntity {

    @ApiModelProperty(hidden = true)
    private long id;

    @ApiModelProperty(example = "Ahmet Gültekin")
    private String fullName;

    @ApiModelProperty(example = "1997-06-01")
    private LocalDate birthDate;

    @ApiModelProperty(example = "İSTANBUL")
    private String address;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(example = "MALE")
    private Gender gender;


}
