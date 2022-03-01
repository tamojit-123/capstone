package com.example.StudentService.service;

import com.example.StudentService.domain.Student;
import com.example.StudentService.exception.StudentAlreadyExitsException;
import com.example.StudentService.exception.StudentNotFoundExcepion;

import java.rmi.StubNotFoundException;
import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student)throws StudentAlreadyExitsException;
    public Student updateStudent(Student student,int id)throws StudentNotFoundExcepion;
    public List<Student> getAllStudent()throws StudentNotFoundExcepion;
    public boolean deleteById(int registrationId)throws StudentNotFoundExcepion;
    public Student getStudentById(int id);
}
