import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../Student';
import { StudentService } from '../student.service';
import { StudentDetails } from '../StudentDetails';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent implements OnInit {

  sId!: number;


  constructor(private studentService: StudentService, private route: ActivatedRoute, private router: Router) { }
  updateStudent: Student = new Student(new StudentDetails())

  ngOnInit(): void {
    this.sId = this.route.snapshot.params['sId'];

    console.log(this.sId);
    this.studentService.getStudentById(this.sId).subscribe(data => {
      this.updateStudent = data;
    }, error => console.log(error))
  }


  update() {
    alert("update is here" + this.sId)
    this.studentService.updateStudent(this.sId, this.updateStudent).subscribe(data => {
      console.log("update" + this.updateStudent)
    }
      , error => console.log(error));
  }

}
