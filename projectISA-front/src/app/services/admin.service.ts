import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private authService: AuthenticationService, private http: HttpClient) { }

  public loadAllUsers() : Observable<User[]>{
    let headers = this.authService.getHeaders();
    return this.http.get<User[]>('http://localhost:8080/api/user/all',{headers:headers});
  }

  public approve(id : number) {
    let headers = this.authService.getHeaders();
    console.log(headers);
    return this.http.get('http://localhost:8080/api/user/approve/'+id, {headers:headers});
  }

  public decline(id : number) {
    let headers = this.authService.getHeaders();
    return this.http.get('http://localhost:8080/api/user/decline/'+id, {headers:headers});
  }
}
