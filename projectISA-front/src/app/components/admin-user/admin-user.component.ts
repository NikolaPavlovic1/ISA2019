import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {

  users : User[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadUsers();
  }

  public loadUsers(){
    /*let headers = new HttpHeaders();
    let token = "Bearer ";
    token += this.storageService.getToken();
    headers = headers.set('Authorization', token);
    */
   
    this.http.get<User[]>('http://localhost:8080/api/user/all').subscribe((data) => {
      this.users = data;
      console.log(data);
    });
  }

  public approve(id : number) {
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
    this.http.post('http://localhost:8080/api/user/approve/'+id, {headers:headers}).subscribe((data) => {
      this.loadUsers();
    });
  }

  public decline(id : number) {
    let headers = new HttpHeaders();
    let token = "Bearer ";
    token += localStorage.getItem('token');
    headers = headers.set('Authorization', token);
    
    this.http.post('http://localhost:8080/api/user/decline/'+id, {headers:headers}).subscribe((data) => {
      this.loadUsers();
    });
  }


}
