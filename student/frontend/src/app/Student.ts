import { StudentDetails } from './StudentDetails'
export class Student{
  registrationId :number=0;
  studentName:string="";
     password:string="";
     studentDetails: StudentDetails;

     constructor(studentDetails: StudentDetails) {
        
        this.studentDetails=studentDetails;
      }
}