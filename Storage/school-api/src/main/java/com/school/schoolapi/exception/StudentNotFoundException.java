package com.school.schoolapi.exception;

public class StudentNotFoundException extends  RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
