import { Component, OnInit, ElementRef } from '@angular/core';
import { User } from 'src/app/model/User';
import { UserService } from 'src/app/service/user.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user: User = new User();
  validation: boolean = true;
  validationName: boolean = false;
  validationSurname: boolean = false;
  validationMail: boolean = false;
  validationAddress: boolean = false;
  validationCity: boolean = false;
  validationCountry: boolean = false;
  validationNumber: boolean = false;
  validationUnique: boolean = false;
  validationPassword: boolean = false;
  repeatPassword: string = "";
  validationRepeatPassword: boolean = false;

  constructor(private userService: UserService, private router: Router, private toastr: ToastrService, private formBuilder: FormBuilder) {

  }

  ngOnInit() {
  }

  register() {

    if (this.user.name == "") {
      this.validationName = true;
      this.validation = false;
    }

    if (this.user.surname == "") {
      this.validationSurname = true;
      this.validation = false;
    }

    if (this.user.email == "") {
      this.validationMail = true;
      this.validation = false;
    }

    if (this.user.address == "") {
      this.validationAddress = true;
      this.validation = false;
    }

    if (this.user.city == "") {
      this.validationCity = true;
      this.validation = false;
    }

    if (this.user.country == "") {
      this.validationCountry = true;
      this.validation = false;
    }

    if (this.user.phoneNumber == null) {
      this.validationNumber = true;
      this.validation = false;
    }

    if (this.user.uniqueNumber == null) {
      this.validationUnique = true;
      this.validation = false;
    }

    if (this.user.password == "") {
      this.validationPassword = true;
      this.validation = false;
    }

    if (this.repeatPassword != this.user.password) {
      // this.toastr.error("Lozinke se ne poklapaju");
      alert('Lozinke nisu iste!');
      this.validationRepeatPassword = true;
      this.validation = false;
    }

    if (!this.validation) {
      // this.toastr.warning("Neuspesna registracija");
      alert('Registracija nije uspesna!');
      this.validation = true;
    } else {
      this.user.username = this.user.email;
      this.userService.registration(this.user).subscribe(
        data => {
          // this.toastr.info("Dobicete e-mail za verifikaciju!");
          alert('E-mail za verifikaciju se salje...');
        },
        error => {

        }
      );
    }
  }
  cancel() {
    this.router.navigate(['/home']);
  }



}
