package com.example.demo.controller;


import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

private final StudentService studentService;

    @GetMapping()
    private ResponseEntity<List<Student>> allStudent(){
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Student> saveStudent(@RequestBody StudentDTO studentDTO){
        Optional<Student> resultOptional = studentService.save(studentDTO);
        if(resultOptional.isPresent())
            return new ResponseEntity<>(resultOptional.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("{id}")
    private ResponseEntity<Student> findStudentById(@PathVariable long id){
        Optional<Student> resultOptional = studentService.findStudentById(id);
        if(resultOptional.isPresent())
            return new ResponseEntity<>(resultOptional.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Student> deleteStudentById(@PathVariable long id){
        return new ResponseEntity(studentService.deleteStudentById(id),HttpStatus.ACCEPTED);
    }


}
