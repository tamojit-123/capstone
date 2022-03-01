import { StudentDetails } from './StudentDetails'
export class Student
{
  studentId: number = 0;
  studentName:string = "";
  studentDetails: StudentDetails;

  constructor(studentDetails: StudentDetails) {
    this.studentDetails=studentDetails;
  }
}
