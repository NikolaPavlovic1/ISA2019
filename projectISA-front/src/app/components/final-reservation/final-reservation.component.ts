import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TypeDuration } from 'src/app/model/TypeDuration';
import { MedicalExamination } from 'src/app/model/MedicalExamination';

@Component({
  selector: 'app-final-reservation',
  templateUrl: './final-reservation.component.html',
  styleUrls: ['./final-reservation.component.css']
})
export class FinalReservationComponent implements OnInit {

  type: TypeDuration = new TypeDuration();
  date: Date;
  price: number;
  doctor: User;

  constructor(private route: ActivatedRoute, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.type = params['type']; //undefined ako nije poslat
      this.date = params['date'];

      console.log(this.type);
      console.log(this.date);

      this.route.paramMap.subscribe(paramMap => {
        let id = +paramMap.get('doctorId');

        let headers = new HttpHeaders();
        let token = "Bearer ";
        token += localStorage.getItem('token');
        headers = headers.set('Authorization', token);


        this.http.get<User>('http://localhost:8080/api/user/' + id, { headers: headers }).subscribe((data) => {
          this.doctor = data;
          console.log(data);
        });
      });
    });

  }

  public reserveExamination() {
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);

    let medicalExamination = new MedicalExamination();
    medicalExamination.doctorId = this.doctor.id;
    medicalExamination.price = this.price;
    medicalExamination.startDateTime = this.date;
    medicalExamination.typeDurationId = this.type.id;
    this.http.get<User>('http://localhost:8080/api/user/' + localStorage.getItem('id'), { headers: headers }).subscribe((data) => {
      let loggedInUser = data;
      medicalExamination.medicalRecordId = loggedInUser.medicalRecord.id;
      this.http.post<MedicalExamination>('http://localhost:8080/api/medical-examination', medicalExamination, { headers: headers }).subscribe((data) => {
        console.log(data);
        alert('Reservation successfull!');
        this.router.navigate["/medical-record"];
      });
    });
  }

  public onChange() {
    this.price = this.type.price;
    console.log(this.type);
  }

}
