import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Payment, Student } from '../model/students.model';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {
 

  constructor(private http: HttpClient) { }
  
  public getAllPayments():Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(`http://localhost:8021/payments`);
  } 

  public getStudents():Observable<Array<Student>> {
    return this.http.get<Array<Student>>(`http://localhost:8021/students`);
  } 
  public getStudentPayments(code:string):Observable<Array<Payment>> {
    return this.http.get<Array<Payment>>(`http://localhost:8021/students/${code}/payments`);
  } 
  public SavePayment(formData: any): Observable<Payment> {
    console.log("SavePayment",formData)
    return this.http.post<Payment>(`http://localhost:8021/payments`,formData);
  } 
  public getPaymentDetails(paymentId:number) {
    return this.http.get(`http://localhost:8021/paymentFile/${paymentId}`, {responseType:'blob'});
  } 

  
}
