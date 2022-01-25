package com.example.demo.mappers;


import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import org.mapstruct.Mapper;

@Mapper
public abstract class InstructorMapper {

    public abstract Instructor ınstructorDTOtoInstructor(InstructorDTO instructorDTO);

}
