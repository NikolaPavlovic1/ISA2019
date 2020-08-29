import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/User';
import { AuthenticationRequest } from '../model/AuthenticationRequest';
import { Router } from '@angular/router';
import { AuthenticationResponse } from '../model/AuthenticationResponse';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient, private router: Router) { }


  public register(user: User) {
    this.http.post<User>('http://localhost:8080/api/user/register', user).subscribe((data) => {
      console.log(data);
      alert("Registration request has been sent to admin!");
    });
  }

  public login(request: AuthenticationRequest) {

    this.http.post<AuthenticationResponse>('http://localhost:8080/api/user/login', request).subscribe((data) => {
      console.log(data);
      localStorage.setItem('id', data.id.toString());
      localStorage.setItem('token', data.token);
      localStorage.setItem('role', data.role);

      if (data.role === "PATIENT") {
        (<HTMLElement>document.getElementById("usersAdminId")).hidden = true;

        (<HTMLElement>document.getElementById("clinicsUserId")).hidden = false;
        (<HTMLElement>document.getElementById("historyUserId")).hidden = false;
        (<HTMLElement>document.getElementById("medicalRecordUserId")).hidden = false;
        (<HTMLElement>document.getElementById("profileUserId")).hidden = false;

        (<HTMLElement>document.getElementById("login")).hidden = true;
        (<HTMLElement>document.getElementById("register")).hidden = true;
        (<HTMLElement>document.getElementById("logout")).hidden = false;
      } else {
        (<HTMLElement>document.getElementById("usersAdminId")).hidden = false;

        (<HTMLElement>document.getElementById("clinicsUserId")).hidden = true;
        (<HTMLElement>document.getElementById("historyUserId")).hidden = true;
        (<HTMLElement>document.getElementById("medicalRecordUserId")).hidden = true;
        (<HTMLElement>document.getElementById("profileUserId")).hidden = false;

        (<HTMLElement>document.getElementById("login")).hidden = true;
        (<HTMLElement>document.getElementById("register")).hidden = true;
        (<HTMLElement>document.getElementById("logout")).hidden = false;
      }

      this.router.navigate(["profile"]);

    },
      (error) => {
        alert("You are not registered to our site!");
      }
    );
  }

  public getHeaders() : HttpHeaders{
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    //headers.set("Access-Control-Allow-Origin", "*")
//headers.set("Access-Control-Allow-Methods", "DELETE, POST, GET, OPTIONS")
//headers.set("Access-Control-Allow-Headers", "Content-Type, Access-Control-Allow-Headers, Authorization, X-Requested-With")
    return headers;
  }



}
