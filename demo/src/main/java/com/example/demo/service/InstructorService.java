package com.example.demo.service;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import com.example.demo.exceptions.InstructorIsAlreadyExistException;
import com.example.demo.mappers.InstructorMapper;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.util.ErrorMessageConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;


    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        Iterable<Instructor> instructorIterable = instructorRepository.findAll();
        instructorIterable.iterator().forEachRemaining(instructorList :: add);
        return instructorList;
    }

    public Optional<Instructor>  findInstructorById(long id) {
        return instructorRepository.findById(id);
    }

    public Optional<Instructor> saveInstructor(InstructorDTO instructorDTO) {
        isExistPhoneNumber(instructorDTO.getPhoneNumber());
        Instructor instructor = instructorMapper.ınstructorDTOtoInstructor(instructorDTO);
       return  Optional.of(instructorRepository.save(instructor));
    }

    public String deleteInstructorById(long id) {
        instructorRepository.deleteById(id);
        return "The Instructor with id number " + id + " has been deleted!" ;
    }

    private void isExistPhoneNumber(String phoneNumber) {
        if(instructorRepository.isExistPhoneNumber(phoneNumber))
            throw new InstructorIsAlreadyExistException(ErrorMessageConstants.INSTRUCTOR_COUNT);

    }
}
