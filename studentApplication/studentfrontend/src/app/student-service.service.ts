import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {Student} from "./student";

@Injectable({
  providedIn: 'root'
})
export class StudentServiceService {

  private apiUrl = "http://localhost:8000/api/v1/studentService/student";

  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<Student[]>{
    return this.httpClient.get<Student[]>(`${this.apiUrl}`);
  }

  createStudent(student: Student): Observable<Object>{
    return this.httpClient.post(`${this.apiUrl}`, student);
  }
  updateStudent(id: number, student: Student): Observable<Object>{
    return this.httpClient.put(`${this.apiUrl}/${id}`, student);
  }

  deleteStudent(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.apiUrl}/${id}`);
  }
  getStudentById(id:number): Observable<Student>{
    return this.httpClient.get<Student>(`${this.apiUrl}/${id}`);
  }

}
