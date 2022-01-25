package com.example.demo.controller;


import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    private ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity(courseService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/save-student-to-course/{studentId}/{courseCode}")
    public ResponseEntity<Course> saveStudentToCourse(@PathVariable long studentId, @PathVariable int courseCode) {

        Optional<Course> resultOptional = courseService.saveStudentToCourse(studentId, courseCode);
        if (resultOptional.isPresent())
            return new ResponseEntity<>(resultOptional.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/save-instructor-to-course/{instructorId}/{courseCode}")
    private ResponseEntity<Course> saveInstructorToCourse(@PathVariable long instructorId,@PathVariable int courseCode){
        Optional<Course> resultOptional = courseService.saveInstructorToCourse(instructorId,courseCode);
        if (resultOptional.isPresent())
            return new ResponseEntity<>(resultOptional.get(),HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



    @PostMapping
    private ResponseEntity<Course> saveCourse(@RequestBody CourseDTO courseDTO){
       Optional<Course> resultOptional = courseService.save(courseDTO);
       if (resultOptional.isPresent())
           return new ResponseEntity<>(resultOptional.get(),HttpStatus.OK);
       return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Course> deleteCourseById(@PathVariable long id){
        return new ResponseEntity(courseService.deleteCourseById(id),HttpStatus.OK);
    }

}
