package com.example.StudentService.service;

import com.example.StudentService.domain.Student;
import com.example.StudentService.exception.StudentAlreadyExitsException;
import com.example.StudentService.exception.StudentNotFoundExcepion;
import com.example.StudentService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService
{

    StudentRepository studentRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) throws StudentAlreadyExitsException {
        if(studentRepository.findById(student.getRegistrationId()).isPresent())
        {
            throw new StudentAlreadyExitsException();
        }
       return studentRepository.save(student);
    }

    @Override
    public Student updateStudent(Student student, int id) throws StudentNotFoundExcepion {
        if(studentRepository.findById(id).isEmpty())
        {
            throw new StudentNotFoundExcepion();
        }
        return studentRepository.save(student);
    }



    @Override
    public List<Student> getAllStudent() throws StudentNotFoundExcepion {
        return studentRepository.findAll();
    }

    @Override
    public boolean deleteById(int registrationId) throws StudentNotFoundExcepion {
        boolean Flag=false;
        if(studentRepository.findById(registrationId).isEmpty())
        {
            throw new StudentNotFoundExcepion();
        }
        else
        {
             studentRepository.deleteById(registrationId);
             Flag=true;
        }
        return Flag;

    }

    @Override
    public Student getStudentById(int id) {
        Student student= studentRepository.findByIds(id);
        return  student;
    }


}
