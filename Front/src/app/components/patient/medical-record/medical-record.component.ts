import { Component, OnInit } from '@angular/core';
import { ExaminationService } from 'src/app/service/examination.service';
import { DatePipe } from '@angular/common';
import { Examination } from 'src/app/model/Examination';

@Component({
  selector: 'app-medical-record',
  templateUrl: './medical-record.component.html',
  styleUrls: ['./medical-record.component.css']
})
export class MedicalRecordComponent implements OnInit {

  examinations: Examination[]=[]

  constructor(private service: ExaminationService, private datePipe: DatePipe) { }

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

}
