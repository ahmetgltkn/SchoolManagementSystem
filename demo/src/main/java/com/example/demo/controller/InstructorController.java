package com.example.demo.controller;


import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aip/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping
    private ResponseEntity<List<Instructor>> findAll(){
        return new ResponseEntity(instructorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Instructor> findInstructorById(@PathVariable long id){
        Optional<Instructor> resultOptional = instructorService.findInstructorById(id);
        if (resultOptional.isPresent())
            return new ResponseEntity(resultOptional.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    private ResponseEntity<Instructor> saveInstructor(@RequestBody InstructorDTO instructorDTO){
        Optional<Instructor> resultOptional = instructorService.saveInstructor(instructorDTO);
        if (resultOptional.isPresent())
            return new ResponseEntity<>(resultOptional.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Instructor> deleteInstructorById(@PathVariable long id){
        return new ResponseEntity(instructorService.deleteInstructorById(id),HttpStatus.OK);
    }
}
