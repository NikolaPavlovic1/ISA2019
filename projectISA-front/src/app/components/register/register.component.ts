import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { HttpClient } from '@angular/common/http';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  password1 : String;
  password2 : String;
  
  constructor(private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  register(){
    if(this.password1 != this.password2) {
      alert("Passwords do not match!");
      return;
    }

    this.user.password = this.password1;
    this.user.role = "PATIENT";
    
    this.authService.register(this.user);
  }

}
