package com.example.studentbackend.controller;

import com.example.studentbackend.model.Student;
import com.example.studentbackend.exception.StudentAlreadyExitsException;
import com.example.studentbackend.exception.StudentNotFoundExcepion;
import com.example.studentbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/studentService/")
public class StudentController {

    StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private ResponseEntity<?> responseEntity;

    @PostMapping("student")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) throws StudentAlreadyExitsException
    {

        try {
            studentService.saveStudent(student);
            responseEntity=new ResponseEntity<>(student, HttpStatus.CREATED);
        }
        catch (StudentAlreadyExitsException e)
        {
            throw new StudentAlreadyExitsException();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PutMapping("student/{id}")
    public ResponseEntity<?>updateStudent(@RequestBody Student student,@PathVariable int id)throws StudentNotFoundExcepion
    {
        try{
            studentService.updateStudent(student, id);
            responseEntity=new ResponseEntity<>(student,HttpStatus.OK);
        }
        catch (StudentNotFoundExcepion e)
        {
            throw new StudentNotFoundExcepion();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("student")
    public ResponseEntity<?>getAllStudent()throws StudentNotFoundExcepion
    {
        try {
            List<Student> studentList = studentService.getAllStudent();
            responseEntity=new ResponseEntity<>(studentList,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error try save after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("student/{studentId}")
    public ResponseEntity<?> deleteById(@PathVariable int studentId) throws StudentNotFoundExcepion
    {
        try {
            studentService.deleteById(studentId);
            responseEntity=new ResponseEntity<>("Successfully deleted!!!!", HttpStatus.OK);
        }
        catch(StudentNotFoundExcepion e)
        {
            throw new StudentNotFoundExcepion();
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error try after sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("student/{id}")
    public  ResponseEntity<?> getStudentById(@PathVariable int id){
        Student student=studentService.getStudentById(id);
        responseEntity=new ResponseEntity<>(student,HttpStatus.OK);
        return responseEntity;
    }

}
