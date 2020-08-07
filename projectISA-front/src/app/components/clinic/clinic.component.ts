import { Component, OnInit } from '@angular/core';
import { Clinic } from 'src/app/model/Clinic';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilterClinics } from 'src/app/model/FilterClinics';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-clinic',
  templateUrl: './clinic.component.html',
  styleUrls: ['./clinic.component.css']
})
export class ClinicComponent implements OnInit {

  clinic: Clinic = new Clinic();
  showBasicInfo: Boolean = true;

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
      });
    });

  }

  public changeShowBasicInfo(value: Boolean) {
    this.showBasicInfo = value;
  }

}
