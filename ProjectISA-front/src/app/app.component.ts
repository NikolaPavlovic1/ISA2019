import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'projectISA-front';
  
  constructor(private http:HttpClient, private router:Router) {

  }
  
  logout(){
    this.http.get<Boolean>('http://localhost:8080/api/user/logout').subscribe((data)=>{
      console.log(data);
      localStorage.removeItem('id');
      localStorage.removeItem('token');
      console.log(localStorage.getItem('id'));
      this.router.navigate(["/"]);
    });
  }
}
