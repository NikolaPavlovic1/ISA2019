import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'projectISA-front';

  constructor(private http: HttpClient, private router: Router) {
  }
  ngOnInit(): void {
    /*(<HTMLElement>document.getElementById("usersAdminId")).hidden = true;

    (<HTMLElement>document.getElementById("clinicsUserId")).hidden = true;
    (<HTMLElement>document.getElementById("historyUserId")).hidden = true;
    (<HTMLElement>document.getElementById("medicalRecordUserId")).hidden = true;
    (<HTMLElement>document.getElementById("profileUserId")).hidden = true;

    (<HTMLElement>document.getElementById("login")).hidden = false;
    (<HTMLElement>document.getElementById("register")).hidden = false;
    (<HTMLElement>document.getElementById("logout")).hidden = true;
*/
  }

  logout() {
    this.http.get<Boolean>('http://localhost:8080/api/user/logout').subscribe((data) => {
      console.log(data);
      localStorage.removeItem('id');
      localStorage.removeItem('token');
      localStorage.removeItem('role');
      console.log(localStorage.getItem('id'));



      (<HTMLElement>document.getElementById("usersAdminId")).hidden = true;
      //(<HTMLElement>document.getElementById("reservationsAdminId")).hidden = true;
      (<HTMLElement>document.getElementById("clinicsUserId")).hidden = true;
      (<HTMLElement>document.getElementById("historyUserId")).hidden = true;
      (<HTMLElement>document.getElementById("medicalRecordUserId")).hidden = true;
      (<HTMLElement>document.getElementById("profileUserId")).hidden = true;


      (<HTMLElement>document.getElementById("login")).hidden = false;
      (<HTMLElement>document.getElementById("register")).hidden = false;
      (<HTMLElement>document.getElementById("logout")).hidden = true;
      
      this.router.navigate(["/"]);
    });
  }


}
