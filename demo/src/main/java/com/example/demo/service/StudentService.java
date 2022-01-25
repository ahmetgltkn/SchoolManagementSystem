package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.TransactionLogger;
import com.example.demo.exceptions.StudentAgeNotValidException;
import com.example.demo.mappers.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.TransactionLoggerRepository;
import com.example.demo.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final TransactionLoggerRepository transactionLoggerRepository;


    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        Iterable<Student> studentIterable = studentRepository.findAll();
        studentIterable.iterator().forEachRemaining(studentList::add);
       return studentList;
    }

    public Optional<Student> save(StudentDTO studentDTO) {
        int year = LocalDate.now().getYear() - studentDTO.getBirthDate().getYear();
        if( year<18 || year>40)
            throw new StudentAgeNotValidException(ErrorMessageConstants.STUDENT_AGE);
        Student student = studentMapper.studentDTOtoStudent(studentDTO);
        return Optional.of(studentRepository.save(student));
    }

    public Optional<Student> findStudentById(long id) {
        return Optional.of(studentRepository.findById(id).get());
    }

    public String deleteStudentById(long id) {
        studentRepository.deleteById(id);

        return "The student with id number " + id + " has been deleted!" ;
    }
}
