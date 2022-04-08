package com.school.schoolapi.exception;

import com.school.schoolapi.dto.ErrorDTO;
import com.school.schoolapi.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MainControllerAdvice {
    @ExceptionHandler(StudentNotFoundException.class)
    protected ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException err){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorDTO("StudentNotFoundException", err.getMessage()));
    }
}
