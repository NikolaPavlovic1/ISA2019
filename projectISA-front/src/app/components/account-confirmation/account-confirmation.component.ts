import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';
import { AdminService } from 'src/app/services/admin.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-account-confirmation',
  templateUrl: './account-confirmation.component.html',
  styleUrls: ['./account-confirmation.component.css']
})
export class AccountConfirmationComponent implements OnInit {

  constructor(private route: ActivatedRoute, private userService: UserService, private router: Router) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe(paramMap => {
      let key = paramMap.get('key');

      this.userService.activateUser(key).subscribe((data) => {
        alert('Confirmation successfull!');
        this.router.navigate(["/login"]);
      });
    });


  }

}
