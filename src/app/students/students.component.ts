import { Student } from './../model/students.model';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';import { StudentsService } from '../services/students.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})
export class StudentsComponent implements OnInit{

  
  students!: Array<Student>;
  public dataSource!: MatTableDataSource<Student>;
  public displayedColumns = ['id', 'firstName', 'lastName', 'code', 'programId','payments'];
  
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  constructor(private studentsService: StudentsService, private router:Router) { }
  
  ngOnInit(): void {
    this.studentsService.getStudents()
      .subscribe({
        next: data => {
          this.students = data;
          this.dataSource = new MatTableDataSource<Student>(this.students);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sort;
        },
        error: err => {
          console.log(err);
        }
      })
  }

  studentPayments(student: Student) {
    this.router.navigateByUrl(`/admin/student-details/${student.code}`)
  }

}