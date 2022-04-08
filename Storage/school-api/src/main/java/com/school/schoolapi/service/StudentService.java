package com.school.schoolapi.service;

import com.school.schoolapi.dto.request.AddressRequestDTO;
import com.school.schoolapi.exception.StudentNotFoundException;
import com.school.schoolapi.model.Address;
import com.school.schoolapi.model.Student;
import com.school.schoolapi.model.mapper.ModelMapper;
import com.school.schoolapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.beans.Transient;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student insert(Student student){
        return studentRepository.save(student);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Student findById(Long id){
        return studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFoundException("Student with ID " + id + " not found."));
    }

    @Transactional
    public Student updateById(Long id, Student updatedStudent){
        Student student = findById(id);

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setBirthDate(updatedStudent.getBirthDate());
        student.setEmail(updatedStudent.getEmail());

        return studentRepository.save(student);
    }

    @Transactional
    public void deleteById(Long id){
        Student student = findById(id);
        studentRepository.deleteById(id);
    }

}
