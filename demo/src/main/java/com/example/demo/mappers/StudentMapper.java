package com.example.demo.mappers;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public abstract class StudentMapper {

    public abstract Student studentDTOtoStudent(StudentDTO studentDTO);
    public abstract StudentDTO studentToStudentDTO(Student student);
}
