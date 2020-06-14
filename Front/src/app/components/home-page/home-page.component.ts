import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  constructor(private router: Router, private route : ActivatedRoute) { }

  ngOnInit() {
  }

  loginClick() {
    this.router.navigate(["login"]);   
  }
  
  registrationClick() {
    this.router.navigate(["registration"]);   
  }


}
