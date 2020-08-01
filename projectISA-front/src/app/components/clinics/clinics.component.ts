import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/model/Address';
import { Clinic } from 'src/app/model/Clinic';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { DatePipe } from '@angular/common';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-clinics',
  templateUrl: './clinics.component.html',
  styleUrls: ['./clinics.component.css']
})
export class ClinicsComponent implements OnInit {

  clinics: Clinic[] = [];
  filteredClinics: Clinic[] = [];
  selectedDoctor: User = new User();
  doctors: User[] = [];

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
      this.filteredClinics = data;
      //this.doctors = [];
      console.log(data);
    });
  }

  public refresh(id: number) {
    /*let i;
    let j;
    this.filteredClinics = [];
    for (i = 0; i < this.clinics.length; i++) {
      for(j = 0 ; j < this.clinics[i].doctors.length ; j++) {
        if (this.clinics[i].doctors[j].id == id || id == 0) {
          this.filteredClinics.push(this.clinics[i]);
        }
      }
      
    }

    if(id == 0) {
      this.selectedDoctor = new User();
      this.selectedDoctor.username == "No filter";
    } else {
      let j;
      for (j = 0; j < this.locations.length; j++) {
        if (this.locations[j].id == id) {
          console.log(this.locations[j]);
          this.selectedLocation = this.locations[j];
        }
      }
    }
    
   */ 
  }


}
