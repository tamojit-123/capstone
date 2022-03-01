package com.example.studentbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
    @Id
    private int studentId;
    private String studentName;
    private StudentDetails studentDetails;


    public Student() {
    }

    public Student(int studentId, String studentName, StudentDetails studentDetails) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDetails = studentDetails;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public StudentDetails getStudentDetails() {
        return studentDetails;
    }

    public void setStudentDetails(StudentDetails studentDetails) {
        this.studentDetails = studentDetails;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
