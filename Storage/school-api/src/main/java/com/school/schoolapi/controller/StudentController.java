package com.school.schoolapi.controller;

import com.school.schoolapi.dto.mapper.MapperDTO;
import com.school.schoolapi.dto.request.StudentRequestDTO;
import com.school.schoolapi.dto.response.StudentResponseDTO;
import com.school.schoolapi.model.mapper.ModelMapper;
import com.school.schoolapi.model.Student;
import com.school.schoolapi.service.StudentService;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(@RequestBody StudentRequestDTO studentDTO,
                                                            UriComponentsBuilder uriBuilder){
        Student student = studentService.insert(ModelMapper.studentDTOToEntity(studentDTO));

        URI uri = uriBuilder
                .path("/{id}")
                .buildAndExpand(student.getId())
                .toUri();

        return ResponseEntity.created(uri).body(MapperDTO.studentToDTO(student));
    }

    @GetMapping()
    public ResponseEntity<List<StudentResponseDTO>> getStudents(){
        List<Student> studentList = studentService.findAll();
        return ResponseEntity.ok(MapperDTO.studentToDTO(studentList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getStudent(@PathVariable Long id){
        Student student = studentService.findById(id);
        return ResponseEntity.ok(MapperDTO.studentToDTO(student));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> updateStudent(@PathVariable Long id,
                                                            @RequestBody StudentRequestDTO studentDTO){
        Student studentUpdated = studentService.updateById(id, ModelMapper.studentDTOToEntity(studentDTO));
        return ResponseEntity.ok(MapperDTO.studentToDTO(studentUpdated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> deleteStudent(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
