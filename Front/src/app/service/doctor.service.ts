import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Doctor } from '../model/Doctor';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http: HttpClient) { }

  doctorSearch(name: string, surname: string, rating: number, doctors : Doctor[]){
    return this.http.post<any>("api/doctors/doctorSearch", { name: name, surname: surname, rating: rating, doctors: doctors})

  }

  evaluateDoctor(rating: number, doctor: Doctor){
    return this.http.post<any>("api/doctors/evaluateDoctor/"+ rating, doctor)
  }
}
