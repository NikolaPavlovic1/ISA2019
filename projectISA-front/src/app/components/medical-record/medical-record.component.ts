import { Component, OnInit } from '@angular/core';
import { MedicalRecord } from 'src/app/model/MedicalRecord';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/model/User';
import { MedicalExaminationHistory } from 'src/app/model/MedicalExaminationHistory';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-medical-record',
  templateUrl: './medical-record.component.html',
  styleUrls: ['./medical-record.component.css']
})
export class MedicalRecordComponent implements OnInit {

  medicalRecord: MedicalRecord = new MedicalRecord();
  examinations: MedicalExaminationHistory[] = [];

  constructor(private patientService: PatientService) { }

  ngOnInit() {
    this.loadMedicalRecord();
  }

  public loadMedicalRecord() {
    this.patientService.loadMedicalRecord().subscribe((data) => {
      this.medicalRecord = data;
      this.patientService.loadMedicalExaminationReservations().subscribe((data) => {
        this.examinations = data;
      });
    });
  }

}
