import { Component, OnInit } from '@angular/core';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MedicalRecord } from 'src/app/model/MedicalRecord';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  examinations : MedicalExamination[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadExaminations();
  }

  public loadExaminations(){
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
   
    this.http.get<MedicalExamination[]>('http://localhost:8080/api/medical-examination/history/'+localStorage.getItem('id')).subscribe((data) => {
      this.examinations = data;
      console.log(data);
    });
  }

  public getDoctor(doctorId: number) {
    
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
   
    this.http.get<User>('http://localhost:8080/api/user/'+doctorId).subscribe((data) => {
      let retVal = data;
      return retVal.name + ' ' + retVal.lastName;
    });

  }

}