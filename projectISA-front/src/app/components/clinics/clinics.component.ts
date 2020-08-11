import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/model/Address';
import { Clinic } from 'src/app/model/Clinic';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { User } from 'src/app/model/User';
import { FilterClinics } from 'src/app/model/FilterClinics';
import { Router } from '@angular/router';

@Component({
  selector: 'app-clinics',
  templateUrl: './clinics.component.html',
  styleUrls: ['./clinics.component.css']
})
export class ClinicsComponent implements OnInit {

  clinics: Clinic[] = [];
  myDate: Date;
  type: string;
  sortType: string;
  sortTypes = ["Name","City","Street"];

  constructor(private http: HttpClient, private datePipe: DatePipe, private router : Router) { }

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
   if(this.myDate == undefined) {
     filterClinic.date = null;
   } else {
    filterClinic.date = JSON.stringify(this.myDate);
    filterClinic.date = filterClinic.date.split('.')[0];
    filterClinic.date = filterClinic.date.substr(1, filterClinic.date.length-2);
   
   }

   if(this.type == undefined || this.type === "") {
     filterClinic.type = null;
   } else {
    filterClinic.type = this.type;
   }
   
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

  public showDoctors(clinicId: number) {
    this.router.navigate( ['doctors', clinicId],{queryParams: { date: this.myDate , type: this.type }});
    
  }

  public onChange() {
    console.log(this.sortType);
    if(this.sortType === "Name") {
      this.clinics.sort((a,b)=>a.name.localeCompare(b.name));
    } else if(this.sortType === "Street"){
      this.clinics.sort((a,b)=>a.address.street.toString().localeCompare(b.address.street.toString()));
    } else {
      this.clinics.sort((a,b)=>a.address.city.toString().localeCompare(b.address.city.toString()));
    }
  }


}
