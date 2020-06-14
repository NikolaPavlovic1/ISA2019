import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  registration(user: User) {
    return this.http.post<User>('api/users/registration', user);
  }

  getCurrentUser() {
    return this.http.get<any>('api/users/currentUser');
  }

  changeData(user: User) {
    return this.http.post<User>('api/users/change', user);
  }
 
}
