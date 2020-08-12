import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationRequest } from 'src/app/model/AuthenticationRequest';
import { AuthenticationResponse } from 'src/app/model/AuthenticationResponse';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email : String;
  password : String;

  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  login(){
    let request = new AuthenticationRequest();
    request.username = this.email;
    request.password = this.password;
    console.log(request);
    
    this.authService.login(request); 
  }

}
