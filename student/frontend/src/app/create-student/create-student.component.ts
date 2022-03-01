import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Student } from '../Student';
import { StudentService } from '../student.service';
import { StudentDetails } from '../StudentDetails';

@Component({
  selector: 'app-create-student',
  templateUrl: './create-student.component.html',
  styleUrls: ['./create-student.component.css']
})
export class CreateStudentComponent implements OnInit  {
 
  
  students: Student[] | undefined;

  constructor(private studentService:StudentService,private route:Router) {}
 
   studentObj:Student=new Student(new StudentDetails())
  
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
  id:number=0;
  deleteStudent(id: number){
    this.studentService.deleteStudent(id).subscribe( data => {
      console.log(data);
      this.getStudents();
    })
  }
  
  updatenav(sId:number){
   
    this.route.navigate(['update',sId]);
    // alert(sId)
  }

  
}
