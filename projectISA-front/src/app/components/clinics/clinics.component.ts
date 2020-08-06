import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/model/Address';
import { Clinic } from 'src/app/model/Clinic';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { User } from 'src/app/model/User';
import { FilterClinics } from 'src/app/model/FilterClinics';

@Component({
  selector: 'app-clinics',
  templateUrl: './clinics.component.html',
  styleUrls: ['./clinics.component.css']
})
export class ClinicsComponent implements OnInit {

  clinics: Clinic[] = [];
  myDate: Date;
  type: string;

  constructor(private http: HttpClient, private datePipe: DatePipe) { }

  ngOnInit() {
    this.reload();
  }

  public reload() {
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
    this.http.get<Clinic[]>('http://localhost:8080/api/clinic/all',{headers:headers}).subscribe((data) => {
      this.clinics = data;
    });
  }

  public refresh() {
    
   let filterClinic = new FilterClinics();
   filterClinic.date = JSON.stringify(this.myDate);
   filterClinic.date = filterClinic.date.split('.')[0];
   filterClinic.date = filterClinic.date.substr(1, filterClinic.date.length-2);
   filterClinic.type = this.type;
   console.log(filterClinic);

   let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
    this.http.post<Clinic[]>('http://localhost:8080/api/clinic/filterClinics',filterClinic,{headers:headers}).subscribe((data) => {
      this.clinics = data;
      console.log(data);
    });

  }


}
