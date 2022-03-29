package com.meli.obterdiploma;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.repository.StudentRepository;
import com.meli.obterdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StudentServiceTest {
    private static StudentService studentService;
    private final static Set<StudentDTO> studentList = buildStudentList();

    @BeforeAll
    public static void setup(){
        StudentDAO studentDAOMock = Mockito.mock(StudentDAO.class);
        StudentRepository studentRepositoryMock = Mockito.mock(StudentRepository.class);
        studentService = new StudentService(studentDAOMock, studentRepositoryMock);

        when(studentRepositoryMock.findAll()).thenReturn(studentList);
        when(studentDAOMock.findById(any(Long.class))).thenReturn(new StudentDTO());
        when(studentDAOMock.delete(any(Long.class))).thenReturn(true);
    }

    @Test
    public void studentListTest(){
        assertEquals(studentList, studentService.getAll());
    }


    public static Set<StudentDTO> buildStudentList(){
        List<SubjectDTO> subjectList1 = Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Química", 8.0));
        StudentDTO studentDTO1 = new StudentDTO(1L, "Mateus",
                null, 8.5, subjectList1);

        List<SubjectDTO> subjectList2 = Arrays.asList(
                new SubjectDTO("Filosofia", 8.5),
                new SubjectDTO("Física", 10.0));
        StudentDTO studentDTO2 = new StudentDTO(2L, "Jorge",
                null, 9.25, subjectList2);

        return Set.of(studentDTO1, studentDTO2);
    }

    public static StudentDTO getStudentSample(){
        List<SubjectDTO> subjectList = Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Química", 8.0));
        return new StudentDTO(1L, "Mateus",
                null, 8.5, subjectList);
    }
}
