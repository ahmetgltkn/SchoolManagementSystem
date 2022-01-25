package com.example.demo.service;
import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Student;
import com.example.demo.exceptions.CourseIsAlreadyExistException;
import com.example.demo.exceptions.StudentNumberForOneCourseExceededException;
import com.example.demo.mappers.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;


    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        Iterable<Course> courseIterable = courseRepository.findAll();
        courseIterable.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    public Optional<Course> save(CourseDTO courseDTO) {
        isExistCourseCode(courseDTO.getCourseCode());
        Course course = courseMapper.courseDTOtoCourse(courseDTO);
        return Optional.of(courseRepository.save(course));
    }


    public String deleteCourseById(long id) {
        courseRepository.deleteById(id);
        return "The cours with id number " + id + " has been deleted!";
    }


    private void isExistCourseCode(int courseCode) {
        boolean isExist = courseRepository.isExistCourseCode(courseCode);
        if (isExist)
            throw new CourseIsAlreadyExistException(ErrorMessageConstants.COURSE_COUNT);
    }


    private Course findCourseByCourseCode(int courseCode) {
        return courseRepository.findCourseByCourseCode(courseCode);
    }

    private Instructor findInstructorById(long instructorId) {
        return instructorRepository.findInstructorById(instructorId);
    }

    public Student findStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    public Optional<Course> saveStudentToCourse(long studentId, int courseCode) {
        Student student = findStudentById(studentId);
        Course course = findCourseByCourseCode(courseCode);
        course.getStudentList().add(student);
        if(course.getStudentList().size() > 20)
            throw new StudentNumberForOneCourseExceededException(ErrorMessageConstants.STUDENT_COUNT);
        return Optional.of(courseRepository.save(course));
    }

    public Optional<Course> saveInstructorToCourse(long instructorId, int courseCode) {
        Instructor instructor = findInstructorById(instructorId);
        Course course = findCourseByCourseCode(courseCode);
        course.setInstructor(instructor);

        return Optional.of(courseRepository.save(course));
    }
}
