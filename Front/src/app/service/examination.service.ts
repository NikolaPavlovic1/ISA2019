import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Examination } from '../model/Examination';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  constructor(private http: HttpClient) { }

  getAllExamination() {
    return this.http.get<any>('api/examinations/all');
  }

  scheduleFreeExamination(examination: Examination) {
    return this.http.post<any>("api/examinations/scheduleFree", examination);
  }

  cancelExamination(examination: Examination) {
    return this.http.post<any>("api/examinations/cancel", examination);
  }

  getScheduledExaminations() {
    return this.http.get<any>('api/examinations/scheduled');
  }

  getHistory() {
    return this.http.get<any>('api/examinations/history');
  }

  getFreeExamination() {
    return this.http.get<any>('api/examinations/allFreeExaminations');
  }

  getExaminationTypes(){
    return this.http.get<any>('api/types/all');
  }

}
