import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { HttpClient } from '@angular/common/http';
import { Clinic } from '../model/Clinic';
import { Observable } from 'rxjs';
import { FilterClinics } from '../model/FilterClinics';
import { MedicalExaminationHistory } from '../model/MedicalExaminationHistory';

@Injectable({
  providedIn: 'root'
})
export class ClinicService {

  constructor(private authService: AuthenticationService, private http:HttpClient) { }

  public loadAllClinics() : Observable<Clinic[]>{
    let headers = this.authService.getHeaders();
    return this.http.get<Clinic[]>('http://localhost:8080/api/clinic/all',{headers:headers});
  }

  public loadClinic(id: string) : Observable<Clinic>{
    let headers = this.authService.getHeaders();
    return this.http.get<Clinic>('http://localhost:8080/api/clinic/' + id, { headers: headers });
  }

  public filterClinics(filter: FilterClinics): Observable<Clinic[]>{
    let headers = this.authService.getHeaders();
    return this.http.post<Clinic[]>('http://localhost:8080/api/clinic/filterClinics',filter,{headers:headers});
  }

  public loadPredefinedExaminations(id: string): Observable<MedicalExaminationHistory[]>{
    let headers = this.authService.getHeaders();
    return this.http.get<MedicalExaminationHistory[]>('http://localhost:8080/api/medical-examination/predefined/' + id, { headers: headers });
  }

  public reservePredefinedExaminations(id: string, userId: string): Observable<Boolean>{
    let headers = this.authService.getHeaders();
    console.log(userId + " " + id);
    return this.http.get<Boolean>('http://localhost:8080/api/medical-examination/predefined/' + userId+'/'+id, { headers: headers });
  }
}
