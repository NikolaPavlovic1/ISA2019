import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthenticationRequest } from 'src/app/model/AuthenticationRequest';
import { AuthenticationResponse } from 'src/app/model/AuthenticationResponse';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username : String;
  password : String;
  

  constructor(private http:HttpClient) { }

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
    });
    
  }

}
