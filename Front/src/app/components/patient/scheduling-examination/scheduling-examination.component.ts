import { Component, OnInit, TemplateRef } from '@angular/core';
import { ClinicService } from 'src/app/service/clinic.service';
import { ExaminationService } from 'src/app/service/examination.service';
import { Examination } from 'src/app/model/Examination';
import { Clinic } from 'src/app/model/Clinic';
import { Doctor } from 'src/app/model/Doctor';
import { ExaminationType } from 'src/app/model/ExaminationType';
import { DoctorService } from 'src/app/service/doctor.service';
import { ToastrService } from 'ngx-toastr';
import { Appointment } from 'src/app/model/Appointment';
import { BsModalRef, BsModalService } from 'ngx-bootstrap';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-scheduling-examination',
  templateUrl: './scheduling-examination.component.html',
  styleUrls: ['./scheduling-examination.component.css']
})


export class SchedulingExaminationComponent implements OnInit {

  showingClinicTable: boolean = false;
  showingDoctorTable: boolean = false;
  allExaminationTypes: ExaminationType[] = [];
  allExaminationTypesDoctor: ExaminationType[] = [];
  clinics: Clinic[] = [];
  doctors: Doctor[] = [];
  examination: ExaminationType = new ExaminationType();
  doctorType: ExaminationType = new ExaminationType();
  price: number;
  nameDoctorSearch: string = "";
  surnameDoctorSearch: string = "";
  doctorRating: number;
  doctor: Doctor = new Doctor();
  scheduledExamination: Examination = new Examination();
  status: string = "SCHEDULED";
  clinicForExamination: Clinic = new Clinic();
  examinationDate: Date;
  validation: boolean = true;
  clinicRating: number;
  clinicLocation: string = "";
  allAppointment: Appointment[] = [];
  appointmentDoctor: Appointment = new Appointment();
  modalRef: BsModalRef;


    constructor(private clinicService: ClinicService, private examinationService: ExaminationService, private doctorService: DoctorService, private toastr: ToastrService, private modalService: BsModalService, private route : ActivatedRoute, private router : Router) { }

ngOnInit() {
  this.examinationService.getExaminationTypes().subscribe(
    data => {

      this.allExaminationTypes = data;
      this.allExaminationTypesDoctor = data;
    },
    error => {
      console.log(error);
    }
  )
}

clinicSearch() {

  if (this.examinationDate == null) {
    // this.toastr.error("Morate izabrati datum pregleda");
    alert('Datum pregleda mora biti izabran!');
    this.validation = false;
  }

  if (this.examination.name == "") {
    // this.toastr.error("Morate izabrati tip pregleda");
    alert('Tip pregleda mora biti izabran!');
    this.validation = false;
  }

  if (!this.validation) {
    this.validation = true;
  } else {
    console.log(this.examination.name);
    this.showingClinicTable = true;
    this.clinicService.clinicSearch(this.examination.name, this.clinicRating, this.clinicLocation).subscribe(
      data => {
        this.clinics = data.clinics;
        this.price = data.examinationPrice;
      }
    )
  }
}
showDoctors(clinic: Clinic) {
  this.showingDoctorTable = true;
  this.doctors = clinic.doctors;
  this.clinicForExamination = clinic;
}

showAppointment(template: TemplateRef<any>, doctor: Doctor){
  this.modalRef = this.modalService.show(template);
  this.allAppointment=doctor.appointments;
  this.doctor=doctor;
}

chooseAppointment(){
  this.scheduledExamination.time=this.appointmentDoctor.appointment;
}

doctorSearch() {

  this.doctorService.doctorSearch(this.nameDoctorSearch, this.surnameDoctorSearch, this.doctorRating, this.doctors).subscribe(
    data => {
      this.doctors = data;
    }
  )

}

scheduleExamination() {

  this.modalRef.hide();
  this.scheduledExamination.typeOfExamination = this.examination;
  this.scheduledExamination.price = this.examination.price;
  this.scheduledExamination.status = this.status;
  this.scheduledExamination.clinic = this.clinicForExamination;
  this.scheduledExamination.doctor = this.doctor;
  this.scheduledExamination.appointment = this.examinationDate;
  this.scheduledExamination.tempTime=this.appointmentDoctor;

  // this.toastr.info("Molimo sacekajte, u toku je zakazivanje pregleda");
  alert('Zakazivanje pregleda u toku...');
  //this.router.navigate(["karton"],{relativeTo: this.route});

  this.examinationService.scheduleFreeExamination(this.scheduledExamination).subscribe(
    data => {
      // this.toastr.success("Uspesno ste zakazali pregled");
      alert('Pregled je uspesno zakazan!');

    },
    error => {
      alert('Izabrani lekar je na godisnjem odmoru za izabrani termin!');
    }
  )

}


}
