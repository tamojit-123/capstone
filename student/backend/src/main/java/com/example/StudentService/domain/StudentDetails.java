package com.example.StudentService.domain;



public class StudentDetails {

    private String email;
    private String studentAddress;
    private String contactNumber;

    public StudentDetails() {
    }

    public StudentDetails(String email, String studentAddress, String contactNumber) {
        this.email = email;
        this.studentAddress = studentAddress;
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "StudentDetails{" +
                "email='" + email + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
