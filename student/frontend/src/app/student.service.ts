import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http'
import { Student } from './Student';


@Injectable({
  providedIn: 'root'
})
export class StudentService {


  private baseURL = "http://localhost:8001/api/v1/studentService/student";

  constructor(private httpClient: HttpClient) { }

  getStudentsList(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(`${this.baseURL}`);
  }

  createStudent(student: Student): Observable<Object> {
    return this.httpClient.post(`${this.baseURL}`, student);
  }
  updateStudent(id: number, student: Student): Observable<Object> {
    return this.httpClient.put(`${this.baseURL}/${id}`, student);
  }

  deleteStudent(id: number): Observable<Object> {
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }

  getStudentById(id: number): Observable<Student> {
    return this.httpClient.get<Student>(`${this.baseURL}/${id}`);
  }

}
