package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.exceptions.StudentAgeNotValidException;
import com.example.demo.mappers.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.util.ErrorMessageConstants;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private  StudentRepository studentRepository;
    private  StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(studentList::add);
        return studentList;
    }

    public Optional<Student> saveStudent(StudentDTO studentDTO) {
        Period studentPeriod = Period.between(studentDTO.getBirthDate(), LocalDate.now());
        if (studentPeriod.getYears() < 18 || studentPeriod.getYears()>40)
            throw new StudentAgeNotValidException(ErrorMessageConstants.STUDENT_AGE);
        Student student = studentMapper.studentDTOtoStudent(studentDTO);
        return  Optional.of(studentRepository.save(student));
    }
}
