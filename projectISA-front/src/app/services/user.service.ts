import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private authService: AuthenticationService, private http: HttpClient) { }

  public loadProfile(id : string) : Observable<User>{
    let headers = this.authService.getHeaders();
    return this.http.get<User>('http://localhost:8080/api/user/'+id,{headers:headers});
  }

  public update(user: User) : Observable<User>{
    let headers = this.authService.getHeaders();
    return this.http.put<User>('http://localhost:8080/api/user', user,{headers:headers});
  }

  public activateUser(key: string): Observable<any> {
    return this.http.get<any>('http://localhost:8080/api/user/activate/' + key);
  }
}