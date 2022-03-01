package com.example.studentbackend.service;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.exception.StudentAlreadyExitsException;
import com.example.studentbackend.exception.StudentNotFoundExcepion;

import java.util.List;

public interface StudentService {

    Student saveStudent(Student student)throws StudentAlreadyExitsException;
    Student updateStudent(Student student, int id)throws StudentNotFoundExcepion;
    List<Student> getAllStudent()throws StudentNotFoundExcepion;
    boolean deleteById(int studentId)throws StudentNotFoundExcepion;
//    public List<Student> getStudentByName(String name);

    Student getStudentById(int id);
}
