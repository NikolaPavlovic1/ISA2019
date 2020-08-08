import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { TypeDuration } from 'src/app/model/TypeDuration';

@Component({
  selector: 'app-final-reservation',
  templateUrl: './final-reservation.component.html',
  styleUrls: ['./final-reservation.component.css']
})
export class FinalReservationComponent implements OnInit {

  type: TypeDuration;
  date: Date;
  doctorUsername: string;
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

  public reserveExamination() {}

  public onChange(mySelect){
    console.log(mySelect);
    this.price = this.type.price;
  }

}
