import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';

@Component({
  selector: 'app-account-confirmation',
  templateUrl: './account-confirmation.component.html',
  styleUrls: ['./account-confirmation.component.css']
})
export class AccountConfirmationComponent implements OnInit {

  constructor(private route: ActivatedRoute, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {

    this.route.paramMap.subscribe(paramMap => {
        let key = paramMap.get('key');

        this.http.post<Boolean>('http://localhost:8080/api/user/activate/' + key,null).subscribe((data) => {
          alert('Confirmation successfull!');
          this.router.navigate(["/login"]);
        });
      });
    

  }

}
