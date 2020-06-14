import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import { User } from 'src/app/model/User';
import { ToastrModule, ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentUser: User=new User();
  name : string = ""; 
  surname : string = "";
  email : string = "";
  city : string = "";
  newPassword : string = "";
  repeatPassword : string = "";
  signal : boolean = true;

  constructor(private router : Router, private route : ActivatedRoute, private service: UserService, private toastr: ToastrService) { }

  ngOnInit() {
    
    this.service.getCurrentUser().subscribe(
      data =>{
        this.currentUser=data;
      },
      error => {
        console.log(error);
      }
    )
  }

  cancel(){
    this.router.navigate(["homePatient"],{relativeTo: this.route}); 
  }

  changeData(){
    if(this.newPassword == ""){
      this.currentUser.password = this.currentUser.tempPassword;
    } else {
      if(this.newPassword == this.repeatPassword){
        this.currentUser.password = this.newPassword;
        this.currentUser.tempPassword = this.newPassword;
        this.signal = true;
      } else {
        this.signal = false;
        // this.toastr.error("Lozinke se ne poklapaju!", this.trenutniKorisnik.ime);
        alert('Lozinke se ne poklapaju!');
      }
      
    }
    if(this.signal) {
      this.service.changeData(this.currentUser).subscribe(
        data => {
          // this.toastr.success("Uspesno ste promenili podatke!", this.trenutniKorisnik.ime);
          alert('Uspesno ste promenili podatke!');
        },
        error => {
    
        }
      );
    }
    
  }

}
