import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Clinic } from '../model/Clinic';

@Injectable({
  providedIn: 'root'
})
export class ClinicService {

  constructor(private http: HttpClient) { }

  getAllClinics(){
    return this.http.get<any>('api/clinics/all');
  }
  clinicSearch(examinationType: string, rating: number, location: string){
    return this.http.post<any>("api/clinics/clinicSearch", { examinationType: examinationType, ratingClinic: rating, clinicLocation: location})

  }

  evaluateClinic(rating: number, clinic: Clinic){
    return this.http.post<any>("api/clinics/evaluateClinic/"+ rating, clinic)
  }
}
