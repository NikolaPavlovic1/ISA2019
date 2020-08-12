import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { FilterDoctors } from '../model/FilterDoctors';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private authService: AuthenticationService, private http: HttpClient) { }

  public loadAllDoctors(filterDoctors: FilterDoctors): Observable<User[]> {
    let headers = this.authService.getHeaders();
    return this.http.post<User[]>('http://localhost:8080/api/clinic/filterDoctors',filterDoctors, { headers: headers });
  }
}
