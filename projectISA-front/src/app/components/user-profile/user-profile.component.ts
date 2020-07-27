import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user : User = new User();

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadUser();
  }

  public loadUser(){
    //let headers = this.authService.getHeaders();

    this.http.get<User>('http://localhost:8080/api/user/1').subscribe((data) => {
      this.user = data;
      console.log(data);
    });
  }

  public update(id : number) {
    //let headers = this.authService.getHeaders();

    /*this.http.delete('http://localhost:8080/api/user/'+id, {headers:headers}).subscribe((data) => {
      this.loadUsers();
    });*/
  }


}
