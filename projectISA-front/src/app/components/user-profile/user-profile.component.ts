import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/User';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';
import { INT_TYPE } from '@angular/compiler/src/output/output_ast';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user : User = new User();
  id : number;

  constructor(private userService:UserService) { }

  ngOnInit() {
    this.id = +localStorage.getItem('id');
    this.loadProfile();
  }

  public loadProfile(){
    this.userService.loadProfile(this.id.toString()).subscribe((data) => {
      this.user = data;
    });
  }

  public update() {
    this.userService.update(this.user).subscribe((data) => {
      alert("Profile updated!");  
      this.loadProfile();
    });
  }


}
