import { Component, OnInit } from '@angular/core';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { MedicalRecord } from 'src/app/model/MedicalRecord';
import { User } from 'src/app/model/User';
import { MedicalExaminationHistory } from 'src/app/model/MedicalExaminationHistory';
import { Rate } from 'src/app/model/Rate';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  examinations : MedicalExaminationHistory[] = [];
  sortTypes = ["Type","Date"];
  sortType: string;

  constructor(private patientService: PatientService) { }

  ngOnInit() {
    this.loadExaminations();
  }

  public loadExaminations(){
    this.patientService.loadMedicalExaminationHistory().subscribe((data) => {
      this.examinations = data;
    });
  }

  public onChange() {
    console.log(this.sortType);
    if(this.sortType === "Type") {
      this.examinations.sort((a,b)=>a.type.localeCompare(b.type));
    } else {
      this.examinations.sort((a,b)=>a.date.toString().localeCompare(b.date.toString()));
    }
  }

  public applyRates(clinicRate:number,doctorRate:number, doctorUsername: string) {
    let rate = new Rate();
    rate.clinicRate = clinicRate;
    rate.doctorRate = doctorRate;
    rate.patientId = +localStorage.getItem('id');
    rate.doctorUsername = doctorUsername;

    this.patientService.rate(rate).subscribe((data) => {
      this.loadExaminations();
    });
  }

}
