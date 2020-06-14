import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/service/AuthService';

@Component({
  selector: 'app-patient',
  templateUrl: './patient.component.html',
  styleUrls: ['./patient.component.css']
})
export class PatientComponent implements OnInit {

  constructor(private router : Router, private route : ActivatedRoute, private serviceLogout : AuthService) { }

  ngOnInit() {
  }

  profileClick(){
   
      this.router.navigate(["profile"],{relativeTo: this.route});   
    
  }

  clinicClick(){

    this.router.navigate(["clinic"],{relativeTo: this.route});

  }

  examinationsClick(){

    this.router.navigate(["examinations"],{relativeTo: this.route});

  }

  logoutClick(){
    this.serviceLogout.logOutUser();
  }

  scheduledExaminations(){

    this.router.navigate(["scheduledExaminations"],{relativeTo: this.route});
    
  }

  schedulingClick(){

    this.router.navigate(["scheduling"],{relativeTo: this.route});
    
  }

  historyClick(){

    this.router.navigate(["history"],{relativeTo: this.route});

  }

  recordClick(){
    this.router.navigate(["record"],{relativeTo: this.route});

  }

}
