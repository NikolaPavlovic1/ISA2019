import { Component, OnInit } from '@angular/core';
import { Examination } from 'src/app/model/Examination';
import { ExaminationService } from 'src/app/service/examination.service';
import { DatePipe } from '@angular/common';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-scheduled-examination',
  templateUrl: './scheduled-examination.component.html',
  styleUrls: ['./scheduled-examination.component.css']
})
export class ScheduledExaminationComponent implements OnInit {

  examinations: Examination[] = [];
  todayDate = new Date;
  cancelDate: Date;

  constructor(private service: ExaminationService, private datePipe: DatePipe, private toastr: ToastrService) { }

  ngOnInit() {
    this.service.getScheduledExaminations().subscribe(
      data => {
        this.examinations = data;
        for (let date of this.examinations) {
          date.medium = this.datePipe.transform(date.appointment, "MMM d, y");
        }
      },
      error => {
        console.log(error);
      }
    )
  }

  cancelExamination(examination1: Examination){
    this.cancelDate= new Date(examination1.appointment)
    if((this.cancelDate.getTime()-this.todayDate.getTime())<86400000){
      // this.toastr.error("Pregled nije moguce otkazati, jer je manje od 24h do pocetka!");
      alert('Zakasnili ste! Pregled se ne moze otkazati manje od 24h pre pocetka.');
    }else{
    this.service.cancelExamination(examination1).subscribe(
      data => {
        // this.toastr.success("Pregled je otkazan!");
        alert('Pregled je otkazan!');
        this.service.getScheduledExaminations().subscribe(
          data => {
            this.examinations = data;
            for (let date of this.examinations) {
              date.medium = this.datePipe.transform(date.appointment, "MMM d, y");
            }
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

}
