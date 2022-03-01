package com.example.StudentService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK,reason = "Student is exits")
public class StudentNotFoundExcepion extends Exception {
}
