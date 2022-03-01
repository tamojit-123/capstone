package com.example.studentbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.OK,reason = "Stusent is exits")
public class StudentNotFoundExcepion extends Exception {
}
