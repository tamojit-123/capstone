package com.example.studentbackend.repository;

import com.example.studentbackend.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {
//    @Query("{'studentName':{$in:[?0]}}")
//    List<Student>getStudentByStudentName(String studentName);

    @Query("{'registrationId':{$in:[?0]}}")
    Student findByIds(int id);
}
