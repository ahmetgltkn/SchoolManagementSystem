package com.example.demo.dto;

import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class CourseDTO extends BaseEntity {

    @ApiModelProperty(hidden = true)
    private long id;
    private String courseName;
    private int courseCode;
    private double creditScore;





}
