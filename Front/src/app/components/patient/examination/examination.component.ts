import { Component, OnInit } from '@angular/core';
import { Examination } from 'src/app/model/Examination';
import { ExaminationService } from 'src/app/service/examination.service';
import { DatePipe } from '@angular/common';
import { error } from 'util';
import { ToastrService } from 'ngx-toastr';
@Component({
  selector: 'app-examination',
  templateUrl: './examination.component.html',
  styleUrls: ['./examination.component.css']
})
export class ExaminationComponent implements OnInit {

  examinations: Examination[] = [];
  todayDate = new Date;
  num : Date;

  constructor(private service: ExaminationService, private datePipe: DatePipe, private toastr: ToastrService) { }

  ngOnInit() {
    this.service.getFreeExamination().subscribe(
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
  transformDate(date) {
    this.datePipe.transform(date, 'yyyy-MM-dd'); //whatever format you need. 
  }

  scheduleFreeExamination(examination: Examination) {
    // this.toastr.info("Molimo sacekajte, u toku je zakazivanje pregleda");
    alert('Zakazivanje pregleda u toku...');
    this.service.scheduleFreeExamination(examination).subscribe(
      data => {
        // this.toastr.warning("Pregled je moguce otkazati najkasnije 24h pre pocetka!", "Upozorenje!", {
          // timeOut: 2000
        // });
        // this.toastr.success("Uspesno ste zakazali pregled");
        alert('Pregled je uspesno zakazan!');

        this.service.getFreeExamination().subscribe(
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
