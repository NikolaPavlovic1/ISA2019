import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TypeDuration } from 'src/app/model/TypeDuration';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { UserService } from 'src/app/services/user.service';
import { PatientService } from 'src/app/services/patient.service';

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

  constructor(private route: ActivatedRoute, private userService: UserService, private router: Router, private patientService:PatientService) { }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.type = params['type']; //undefined ako nije poslat
      this.date = params['date'];

      console.log(this.type);
      console.log(this.date);

      this.route.paramMap.subscribe(paramMap => {
        let id = paramMap.get('doctorId');

        this.userService.loadProfile(id).subscribe((data) => {
          this.doctor = data;
        });
      });
    });
  }

  public reserveExamination() {
    let medicalExamination = new MedicalExamination();
    medicalExamination.doctorId = this.doctor.id;
    medicalExamination.price = this.price;
    medicalExamination.startDateTime = this.date;
    medicalExamination.typeDurationId = this.type.id;
    
    this.userService.loadProfile(localStorage.getItem('id')).subscribe((data) => {
      let loggedInUser = data;
      medicalExamination.medicalRecordId = loggedInUser.medicalRecord.id;
      this.patientService.reserveExamination(medicalExamination).subscribe((data) => {
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
