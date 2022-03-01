package com.example.StudentService.repository;

import com.example.StudentService.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer> {
    @Query("{'registrationId':{$in:[?0]}}")
    Student findByIds(int id);
}
