package com.example.StudentService.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "Student already exits")
public class StudentAlreadyExitsException extends Exception {
}
