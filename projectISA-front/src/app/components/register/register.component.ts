import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  password1 : String;
  password2 : String;
  

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
  }

  register(){
    if(this.password1 != this.password2) {
      alert("Passwords do not match!");
      return;
    }

    this.user.password = this.password1;

    this.http.post<User>('http://localhost:8080/api/user',this.user).subscribe((data)=>{
      console.log(data);
      alert("Registration successfull");

    });
    
  }

}
