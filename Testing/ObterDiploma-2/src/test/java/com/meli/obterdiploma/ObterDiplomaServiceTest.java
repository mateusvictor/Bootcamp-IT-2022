package com.meli.obterdiploma;

import com.meli.obterdiploma.model.StudentDTO;
import com.meli.obterdiploma.model.SubjectDTO;
import com.meli.obterdiploma.repository.IStudentDAO;
import com.meli.obterdiploma.repository.StudentDAO;
import com.meli.obterdiploma.service.ObterDiplomaService;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class ObterDiplomaServiceTest {
    private ObterDiplomaService diplomaService;

    @BeforeAll
    public void setup(){
        StudentDAO studentDAO = Mockito.mock(StudentDAO.class);
        diplomaService = new ObterDiplomaService(studentDAO);

        List<SubjectDTO> subjectDTOList1 = Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Química", 8.0));
        StudentDTO studentDTO1 = new StudentDTO(1L, "Mateus",
                null, 8.5, subjectDTOList1);

        List<SubjectDTO> subjectDTOList2 = Arrays.asList(
                new SubjectDTO("Filosofia", 8.5),
                new SubjectDTO("Física", 10.0));
        StudentDTO studentDTO2 = new StudentDTO(2L, "Jorge",
                null, 9.25, subjectDTOList2);

        when(studentDAO.findById(1L)).thenReturn(studentDTO1);
        when(studentDAO.findById(2L)).thenReturn(studentDTO2);
    }

    @Test
    public void testAverage(){
        StudentDTO studentDTO1 = diplomaService.analyzeScores(1L);
        StudentDTO studentDTO2 = diplomaService.analyzeScores(2L);

        assertEquals(8.5, studentDTO1.getAverageScore());
        assertEquals(9.25, studentDTO2.getAverageScore());
    }

    @Test
    public void testMessage(){
        StudentDTO studentDTO1 = diplomaService.analyzeScores(1L);
        StudentDTO studentDTO2 = diplomaService.analyzeScores(2L);

        assertEquals("O aluno Mateus obteve uma média de 8,5. Você pode melhorar.", studentDTO1.getMessage());
        assertEquals("O aluno Jorge obteve uma média de 9,25. Parabéns!", studentDTO2.getMessage());
    }
}
