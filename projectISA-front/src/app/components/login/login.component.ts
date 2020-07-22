import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

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
    
    
    /*this.http.post<User>('http://localhost:8080/api/user',this.user).subscribe((data)=>{
      console.log(data);


    });
    */
  }

}
