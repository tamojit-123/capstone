package com.example.StudentService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {
    @Id
    private int registrationId;
    private String studentName;
    private String password;
    private StudentDetails studentDetails;


    public Student() {
    }

    public Student(int registrationId, String studentName, String password, StudentDetails studentDetails) {
        this.registrationId = registrationId;
        this.studentName = studentName;
        this.password = password;
        this.studentDetails = studentDetails;
    }

    public int getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(int registrationId) {
        this.registrationId = registrationId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                "registrationId=" + registrationId +
                ", studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                ", studentDetails=" + studentDetails +
                '}';
    }
}
