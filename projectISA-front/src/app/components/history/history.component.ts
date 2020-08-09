import { Component, OnInit } from '@angular/core';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MedicalRecord } from 'src/app/model/MedicalRecord';
import { User } from 'src/app/model/User';
import { MedicalExaminationHistory } from 'src/app/model/MedicalExaminationHistory';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  examinations : MedicalExaminationHistory[] = [];
  sortTypes = ["Type","Date"];
  sortType: string;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadExaminations();
  }

  public loadExaminations(){
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
   
    this.http.get<MedicalExaminationHistory[]>('http://localhost:8080/api/medical-examination/history/'+localStorage.getItem('id')).subscribe((data) => {
      this.examinations = data;
      console.log(data);
    });
  }

  

  public onChange() {
    console.log(this.sortType);
    if(this.sortType === "Type") {
      this.examinations.sort((a,b)=>a.type.localeCompare(b.type));
    } else {
      this.examinations.sort((a,b)=>a.date.toString().localeCompare(b.date.toString()));
    }
  }

}
