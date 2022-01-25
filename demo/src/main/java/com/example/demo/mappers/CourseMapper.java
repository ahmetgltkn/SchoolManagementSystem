package com.example.demo.mappers;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public abstract class CourseMapper {

    public abstract Course courseDTOtoCourse(CourseDTO customerDTO);


}
