import { Component, OnInit } from '@angular/core';
import { Clinic } from 'src/app/model/Clinic';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilterClinics } from 'src/app/model/FilterClinics';
import { ActivatedRoute } from '@angular/router';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { MedicalExaminationHistory } from 'src/app/model/MedicalExaminationHistory';

@Component({
  selector: 'app-clinic',
  templateUrl: './clinic.component.html',
  styleUrls: ['./clinic.component.css']
})
export class ClinicComponent implements OnInit {

  clinic: Clinic = new Clinic();
  view: string = "basic";
  predefinedExaminations: MedicalExaminationHistory[] = [];

  constructor(private http: HttpClient, private route: ActivatedRoute) { }

  ngOnInit() {
    this.reload();
  }

  public reload() {
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);

    this.route.paramMap.subscribe(paramMap => {
      let id = paramMap.get('id');
      console.log(id);
      this.http.get<Clinic>('http://localhost:8080/api/clinic/' + id, { headers: headers }).subscribe((data) => {
        this.clinic = data;
        console.log(this.clinic);
        this.http.get<MedicalExaminationHistory[]>('http://localhost:8080/api/medical-examination/predefined/' + id, { headers: headers }).subscribe((data) => {
          this.predefinedExaminations = data;
          console.log(this.predefinedExaminations);
        });
      });
    });

  }

  public changeView(value: string) {
    console.log(value);
    this.view = value;
  }

  public reserve(id: number) {
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
    console.log(id);
    let userId = localStorage.getItem('id');

    this.http.post<Boolean>('http://localhost:8080/api/medical-examination/predefined/' + userId+"/"+id, { headers: headers }).subscribe((data) => {
      this.reload();
    });
  }


}
