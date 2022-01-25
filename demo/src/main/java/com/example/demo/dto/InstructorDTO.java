package com.example.demo.dto;

import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDTO extends BaseEntity {

    @ApiModelProperty(hidden = true)
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
}
