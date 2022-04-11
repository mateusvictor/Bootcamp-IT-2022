package br.meli.movies_db_orm.exception;

import br.meli.movies_db_orm.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException err){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ErrorDTO("EntityNotFoundException", err.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<?> argumentNotValidException(MethodArgumentNotValidException err) {
        List<ObjectError> allErrors = err.getBindingResult().getAllErrors();
        List<ErrorDTO> errorDTOS = new ArrayList<>();
        allErrors.forEach(
                objectError -> errorDTOS.add(
                        new ErrorDTO("MethodArgumentNotValidException", objectError.getDefaultMessage()))
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTOS);
    }
}
