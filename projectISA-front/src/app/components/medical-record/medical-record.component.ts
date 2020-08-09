import { Component, OnInit } from '@angular/core';
import { MedicalRecord } from 'src/app/model/MedicalRecord';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';
import { MedicalExaminationHistory } from 'src/app/model/MedicalExaminationHistory';

@Component({
  selector: 'app-medical-record',
  templateUrl: './medical-record.component.html',
  styleUrls: ['./medical-record.component.css']
})
export class MedicalRecordComponent implements OnInit {

  medicalRecord: MedicalRecord = new MedicalRecord();
  examinations: MedicalExaminationHistory[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadMedicalRecord();
  }

  public loadMedicalRecord() {
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);


    this.http.get<MedicalRecord>('http://localhost:8080/api/medical-record/' + localStorage.getItem('id')).subscribe((data) => {
      this.medicalRecord = data;
      console.log(data);
      this.http.get<MedicalExaminationHistory[]>('http://localhost:8080/api/medical-examination/future/' + localStorage.getItem('id')).subscribe((data) => {
        this.examinations = data;
        console.log(data);
      });
    });
  }

}
