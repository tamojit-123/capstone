package com.example.studentbackend.service;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.exception.StudentAlreadyExitsException;
import com.example.studentbackend.exception.StudentNotFoundExcepion;
import com.example.studentbackend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    StudentRepository studentRepository;


    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveStudent(Student student) throws StudentAlreadyExitsException {
        if(studentRepository.findById(student.getStudentId()).isPresent())
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
    public boolean deleteById(int studentId) throws StudentNotFoundExcepion {
        boolean Flag=false;
        if(studentRepository.findById(studentId).isEmpty()) {
            throw new StudentNotFoundExcepion();
        }
        else {
            studentRepository.deleteById(studentId);
            Flag=true;
        }
        return Flag;

    }

//    @Override
//    public List<Student> getStudentByName(String name) {
//        return studentRepository.getStudentByStudentName(name);
//    }

    @Override
    public Student getStudentById(int id) {
        Student student= studentRepository.findByIds(id);
        return  student;
    }
}
