import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
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

  public delete(id : number) {
    //let headers = this.authService.getHeaders();

    /*this.http.delete('http://localhost:8080/api/user/'+id, {headers:headers}).subscribe((data) => {
      this.loadUsers();
    });*/
  }


}
