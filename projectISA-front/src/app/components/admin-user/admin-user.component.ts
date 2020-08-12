import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/services/user.service';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-user',
  templateUrl: './admin-user.component.html',
  styleUrls: ['./admin-user.component.css']
})
export class AdminUserComponent implements OnInit {

  users: User[] = [];

  constructor(private adminService: AdminService) { }

  ngOnInit() {
    this.loadUsers();
  }

  public loadUsers() {
    this.adminService.loadAllUsers().subscribe((data) => {
      this.users = data;
    });
  }

  public approve(id: number) {
    this.adminService.approve(id).subscribe((data) => {
      this.loadUsers();
    });
  }

  public decline(id: number) {
    this.adminService.decline(id).subscribe((data) => {
      this.loadUsers();
    });
  }


}
