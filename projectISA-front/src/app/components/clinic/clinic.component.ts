import { Component, OnInit } from '@angular/core';
import { Clinic } from 'src/app/model/Clinic';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { FilterClinics } from 'src/app/model/FilterClinics';
import { ActivatedRoute } from '@angular/router';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { MedicalExaminationHistory } from 'src/app/model/MedicalExaminationHistory';
import { ClinicService } from 'src/app/services/clinic.service';

@Component({
  selector: 'app-clinic',
  templateUrl: './clinic.component.html',
  styleUrls: ['./clinic.component.css']
})
export class ClinicComponent implements OnInit {

  clinic: Clinic = new Clinic();
  view: string = "basic";
  predefinedExaminations: MedicalExaminationHistory[] = [];

  constructor(private clinicService:ClinicService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.reload();
  }

  public reload() {;
    this.route.paramMap.subscribe(paramMap => {
      let id = paramMap.get('id');
      console.log(id);
      this.clinicService.loadClinic(id).subscribe((data) => {
        this.clinic = data;
        console.log(this.clinic);
        this.clinicService.loadPredefinedExaminations(id).subscribe((data) => {
          this.predefinedExaminations = data;
          console.log(this.predefinedExaminations);
        });
      });
    });

  }

  public changeView(value: string) {
    console.log(value);
    this.view = value;
  }

  public reserve(id: number) {
    console.log(id);
    let userId = localStorage.getItem('id');
    this.clinicService.reservePredefinedExaminations(id.toString(),userId).subscribe((data) => {
      this.reload();
    });
  }


}
