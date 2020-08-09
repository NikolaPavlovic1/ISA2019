import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationRequest } from 'src/app/model/AuthenticationRequest';
import { AuthenticationResponse } from 'src/app/model/AuthenticationResponse';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username : String;
  password : String;
  

  constructor(private http:HttpClient,private router:Router) { }

  ngOnInit(): void {
  }

  login(){
    
    let request = new AuthenticationRequest();
    request.username = this.username;
    request.password = this.password;
    
    this.http.post<AuthenticationResponse>('http://localhost:8080/api/user/login',request).subscribe((data)=>{
      console.log(data);
      localStorage.setItem('id',data.id.toString());
      localStorage.setItem('token',data.token);
      localStorage.setItem('role',data.role);

      if(data.role === "PATIENT") {
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
      
      this.router.navigate(["/profile"]);




    },
    (error) => {
      alert("You are not registered to our site!");
    }
    );
    
  }

}
