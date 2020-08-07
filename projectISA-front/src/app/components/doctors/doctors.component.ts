import { Component, OnInit } from '@angular/core';
import { Clinic } from 'src/app/model/Clinic';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { ActivatedRoute } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';
import { FilterDoctors } from 'src/app/model/FilterDoctors';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  clinic: Clinic;
  filteredDoctors: User[] = [];
  selectedDoctor: User = new User();
  type: string = "";
  date: Date;
  firstName: string = "";
  lastName: string = "";
  rate: number;
  //medicalExamination: MedicalExamination = new MedicalExamination();
  id: number;

  constructor(private route: ActivatedRoute, private http: HttpClient) {}

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.type = params['type']; //undefined ako nije poslat
      this.date = params['date'];
      console.log(this.type);
      console.log(this.date);

      this.route.paramMap.subscribe(paramMap => {
        this.id = +paramMap.get('idClinic');

        this.loadAllDoctors();
      });
    });

  }

  public loadAllDoctors() {

    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);

    let filterC = new FilterDoctors();

    filterC.clinicId = this.id;
    
    if(this.date != undefined) {
      filterC.date = JSON.stringify(this.date);
      filterC.date = filterC.date.split('.')[0];
      filterC.date = filterC.date.substr(1, filterC.date.length-2);
    } else {
      filterC.date = "";
    }

    filterC.type = this.type;

    filterC.firstName = this.firstName;
    filterC.lastName = this.lastName;
    filterC.rate = this.rate;

    //posle loada klinike metoda na bekendu koja vraca doktore sa tipom i datumom
    this.http.post<User[]>('http://localhost:8080/api/clinic/filterDoctors',filterC, { headers: headers }).subscribe((data) => {
      this.filteredDoctors = data;
      console.log(this.clinic);
    });
  }

  public selectDoctor(id: number) {
    let i;
    for (i = 0; i < this.filteredDoctors.length; i++) {
      if (this.filteredDoctors[i].id == id) {
        this.selectedDoctor = this.filteredDoctors[i];
        console.log(this.selectedDoctor);
      }
    }
  }


  public doFilter(myForm) {
    console.log(myForm.value);
  }

  public proceed() {
    if(this.type === "" || this.selectedDoctor.hasOwnProperty('id')) {
      alert('You must select doctor and choose type!');
      return;
    }

    console.log(this.selectedDoctor);
  }


}
