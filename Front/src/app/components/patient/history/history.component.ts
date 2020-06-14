import { Component, OnInit, TemplateRef } from '@angular/core';
import { ExaminationService } from 'src/app/service/examination.service';
import { DatePipe } from '@angular/common';
import { Examination } from 'src/app/model/Examination';
import { Sort } from '@angular/material';
import { BsModalService, BsModalRef } from 'ngx-bootstrap';
import { Clinic } from 'src/app/model/Clinic';
import { Doctor } from 'src/app/model/Doctor';
import { DoctorService } from 'src/app/service/doctor.service';
import { ClinicService } from 'src/app/service/clinic.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  examinations: Examination[] = [];
  sortedData;
  new : number;
  modalRef: BsModalRef;
  clinicName : string="";
  clinicAddress : string="";
  clinicCity : string="";
  clinicRating : number;
  doctorName : string="";
  doctorSurname : string="";
  doctorRating : number;
  doctorForRating: Doctor = new Doctor;
  evaluatedDoctor: any;
  evaluatedClinic : any;
  clinicForRating: Clinic =  new Clinic;

  constructor(private service: ExaminationService, private datePipe: DatePipe, private modalService: BsModalService, private doctorService: DoctorService, private clinicService: ClinicService) { 
    this.sortedData = this.examinations.slice();
  }

  ngOnInit() {
    this.service.getHistory().subscribe(
      data => {
        this.examinations = data;
        
        for (let date of this.examinations) {
          date.medium = this.datePipe.transform(date.appointment, "d MMM y, h:mm a");
        }
        this.sortedData=this.examinations;
      },
      error => {
        console.log(error);
      }
    )
  }

  transformDate(date) {
    this.datePipe.transform(date, 'yyyy-MM-dd'); //whatever format you need. 
  }

  sortData(sort: Sort) {
    const data = this.examinations.slice();
    if (!sort.active || sort.direction == '') {
      this.sortedData = data;
      return;
    }

    this.sortedData = data.sort((a, b) => {
      let isAsc = sort.direction == 'asc';
      switch (sort.active) {
        case 'id': return compare(a.id, b.id, isAsc);
        case 'price': return compare(a.price, b.price, isAsc);
        case 'discount': return compare(+a.discount, +b.discount, isAsc);
        case 'type': return compareString(a.typeOfExamination.name, b.typeOfExamination.name, isAsc);
        case 'hall': return compare(+a.hall, +b.hall, isAsc);
        case 'duration': return compare(+a.duration, +b.duration, isAsc);
        case 'status': return compareString(a.status, b.status, isAsc);
        case 'doctor': return compareString(a.doctor.name, b.doctor.name, isAsc);
        case 'clinic': return compareString(a.clinic.name, b.clinic.name, isAsc);
        case 'medium': return compareDate(a.appointment, b.appointment, isAsc);
        default: return 0;
      }
    });
  }

  evaluateClinic(template: TemplateRef<any>, ex: Examination) {
    this.clinicForRating= ex.clinic;
    this.modalRef = this.modalService.show(template);
    this.clinicName=ex.clinic.name;
    this.clinicAddress=ex.clinic.address;
    this.clinicCity=ex.clinic.city;
    this.evaluatedClinic=ex.clinic.rating;
  }

  evaluateDoctor(template: TemplateRef<any>, ex: Examination) {
    this.doctorForRating= ex.doctor;
    this.modalRef = this.modalService.show(template);
    this.doctorName=ex.doctor.name;
    this.doctorSurname=ex.doctor.surname;
    this.evaluatedDoctor=ex.doctor.rating;
  
  }

  cancel(){
    this.modalRef.hide();
  }

  evaluateCl(){
    this.modalRef.hide();

    this.clinicService.evaluateClinic(this.evaluatedClinic, this.clinicForRating).subscribe(
      data => {
        this.service.getHistory().subscribe(
          data => {
            this.examinations = data;
            
            for (let date of this.examinations) {
              date.medium = this.datePipe.transform(date.appointment, "d MMM y, h:mm a");
            }
            this.sortedData=this.examinations;
          },
          error => {
            console.log(error);
          }
        )
      },
      error => {
        console.log(error);
      }
    )

    
  }

  evaluateDoc(){
    this.modalRef.hide();

    this.doctorService.evaluateDoctor(this.evaluatedDoctor, this.doctorForRating).subscribe(
      data => {
        this.service.getHistory().subscribe(
          data => {
            this.examinations = data;
            
            for (let date of this.examinations) {
              date.medium = this.datePipe.transform(date.appointment, "d MMM y, h:mm a");
            }
            this.sortedData=this.examinations;
          },
          error => {
            console.log(error);
          }
        )
      },
      error => {
        console.log(error);
      }
    )

    

  }

}

function compare(a: number, b: number, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

function compareString(a: string, b: string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

function compareDate(a: Date, b: Date, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

