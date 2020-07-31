import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { INT_TYPE } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user : User = new User();
  id : number;

  constructor(private http: HttpClient, private route: ActivatedRoute,private router: Router) { }

  ngOnInit() {
    this.id = +localStorage.getItem('id');
    this.loadProfile();
   

    
  }

  public loadProfile(){
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);

    this.http.get<User>('http://localhost:8080/api/user/'+this.id).subscribe((data) => {
      this.user = data;
      console.log(data);
    });
  }

  public update() {
    //let headers = this.authService.getHeaders();

    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);

    this.http.put<User>('http://localhost:8080/api/user', this.user,{headers:headers}).subscribe((data) => {
      this.loadProfile();
    });
  }


}
