package com.meli.obterdiploma.exception;

import com.meli.obterdiploma.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<List<ErrorDTO>> handleValidationsExceptions(MethodArgumentNotValidException e){
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<ErrorDTO> errorDTOS = new ArrayList<>();

        allErrors.forEach(
                objectError -> errorDTOS.add(
                        new ErrorDTO("Campo invalido.", objectError.getDefaultMessage()))
        );

        return new ResponseEntity<>(errorDTOS, HttpStatus.BAD_REQUEST);
    }
}
