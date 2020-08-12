import { Injectable } from '@angular/core';
import { AuthenticationService } from './authentication.service';
import { HttpClient } from '@angular/common/http';
import { MedicalRecord } from '../model/MedicalRecord';
import { MedicalExaminationHistory } from '../model/MedicalExaminationHistory';
import { Observable } from 'rxjs';
import { Rate } from '../model/Rate';
import { MedicalExamination } from '../model/MedicalExamination';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private authService: AuthenticationService, private http: HttpClient) { }

  public loadMedicalRecord(): Observable<MedicalRecord> {
    let headers = this.authService.getHeaders();
    return this.http.get<MedicalRecord>('http://localhost:8080/api/medical-record/' + localStorage.getItem('id'), { headers: headers });
  }

  public loadMedicalExaminationReservations(): Observable<MedicalExaminationHistory[]> {
    let headers = this.authService.getHeaders();
    return this.http.get<MedicalExaminationHistory[]>('http://localhost:8080/api/medical-examination/future/' + localStorage.getItem('id'),{headers:headers});
  }

  public loadMedicalExaminationHistory(): Observable<MedicalExaminationHistory[]> {
    let headers = this.authService.getHeaders();
    return this.http.get<MedicalExaminationHistory[]>('http://localhost:8080/api/medical-examination/history/'+localStorage.getItem('id'),{headers:headers});
  }

  public rate(rate: Rate): Observable<Boolean> {
    let headers = this.authService.getHeaders();
    return this.http.post<Boolean>('http://localhost:8080/api/user/rate',rate,{headers:headers});
  }

  public reserveExamination(medicalExamination: MedicalExamination): Observable<MedicalExamination> {
    let headers = this.authService.getHeaders();
    return this.http.post<MedicalExamination>('http://localhost:8080/api/medical-examination', medicalExamination, { headers: headers });
  }

}
