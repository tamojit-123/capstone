import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {StudentServiceService} from "../student-service.service";
import {Student} from "../student";
import {StudentDetails} from "../StudentDetails";
import { Router } from '@angular/router';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})

export class StudentComponent implements OnInit {

  title = 'Student CRUD Application';

  students: Student[] | undefined;
  constructor(private studentService:StudentServiceService, private router: Router) {}

  studentObj:Student = new Student(new StudentDetails())

  ngOnInit(): void {

    this.getStudents()
    console.log("student form data"+this.studentObj)
  }

  saveStudent(){
    console.log()
    this.studentService.createStudent(this.studentObj).subscribe( data =>{
        console.log("save method"+data);
      },
      error => console.log(error));
  }

  onSubmit(){
    this.saveStudent();
    console.log(this.studentObj)
  }

  private getStudents(){
    this.studentService.getStudentsList().subscribe(data => {
      this.students = data;
    });
  }

  id:number = 0;
  deleteStudent(id: number){
    this.studentService.deleteStudent(id).subscribe( data => {
      console.log(data);
      this.getStudents();
    });
  }

  // update(){
  //   this.studentService.updateStudent(this.studentObj.studentId, this.studentObj).subscribe( data =>{
  //       this.getStudents();
  //     }
  //     , error => console.log(error));
  // }

  update(sId:number){
    this.router.navigate(['update',sId]);
  }
}
