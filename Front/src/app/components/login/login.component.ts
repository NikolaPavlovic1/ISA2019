import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from 'src/app/model/User';
import { AuthService } from 'src/app/service/AuthService';
import { UserService } from 'src/app/service/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User = new User();
  validation: boolean = true;
  validationUsername: boolean = false;
  validationPassword: boolean = false;

  constructor(private toastr: ToastrService, private authService: AuthService, private router: Router, private route: ActivatedRoute, private userService: UserService, private serviceOdjava: AuthService) {
    if (!this.authService.isUserLogged()) {
      this.router.navigate(['/login']);
    } else {
      if (localStorage.getItem("ROLE") == "ADMIN_SISTEM") {
        this.router.navigate(['/adminSistema']);
      }

      else if (localStorage.getItem("ROLE") == "REGISTROVAN") {
        this.router.navigate(['/registered']);
      }

    }
  }

  ngOnInit() {
  }


  clickLogIn() {

    if (this.user.username == "") {
      this.validationUsername = true;
      this.validation = false;

    }

    if (this.user.password == "") {
      this.validationPassword = true;
      this.validation = false;
    }

    if (!this.validation) {
      // this.toastr.warning("Neuspesna prijava");
      alert('Prijava nije uspela!');
      this.validation = true;
    } else {
      this.authService.login(this.user).subscribe(
        success => {

          if (!success) {
            //this.toastr.error("Neispravni kredencijali");
            alert('Pogresno korisnicko ime ili lozinka!');
          } else {
            this.authService.getCurrentUser().subscribe(
              data => {
                localStorage.setItem("ROLE", data.role);
                localStorage.setItem("USERNAME", data.username);
                if (localStorage.getItem("ROLE") == "REGISTERED") {
                  this.router.navigate(["/registered"]);
                } else {
                  localStorage.removeItem("AGENT_JWT_TOKEN");
                  alert('Niste verifikovali nalog!');
                  //this.router.navigate(["/pocetna"]);
                }
              }
            )
          }
        }
      )
    }
  }

  cancel() {
    this.router.navigate(['/home']);
  }

}
