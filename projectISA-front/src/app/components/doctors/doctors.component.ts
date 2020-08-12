import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User} from '../../model/User';
import { FilterDoctors} from '../../model/FilterDoctors';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-doctors',
  templateUrl: './doctors.component.html',
  styleUrls: ['./doctors.component.css']
})
export class DoctorsComponent implements OnInit {

  filteredDoctors: User[] = [];
  selectedDoctor: User = new User();

  type: string = "";
  date: Date;
  firstName: string;
  lastName: string;
  rate: number;
  id: number;

  showDate: boolean = false;
  showType: boolean = false;

  constructor(private route: ActivatedRoute, private doctorService: DoctorService, private router: Router) {}

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.type = params['type']; //undefined ako nije poslat
      this.date = params['date'];
      if(this.type == undefined) {
        this.showType = true;
      }
      if(this.date == undefined) {
        this.showDate = true;
      }

      console.log(this.type);
      console.log(this.date);

      this.route.paramMap.subscribe(paramMap => {
        this.id = +paramMap.get('idClinic');

        this.loadAllDoctors();
      });
    });

  }

  public loadAllDoctors() {
    let filterC = new FilterDoctors();

    filterC.clinicId = this.id;
    
    if(this.date != undefined) {
      filterC.date = JSON.stringify(this.date);
      filterC.date = filterC.date.split('.')[0];
      filterC.date = filterC.date.substr(1, filterC.date.length-2);
    } else {
      filterC.date = null;
    }

    if(this.type != undefined && this.type!= "") {
      filterC.type = this.type;
    } else {
      filterC.type = null;
    }
    
    if(this.firstName == undefined || this.firstName === "") {
      filterC.firstName = null;
    } else {
      filterC.firstName = this.firstName;
    }

    if(this.lastName == undefined || this.lastName === "") {
      filterC.lastName = null;
    } else {
      filterC.lastName = this.lastName;
    }

    if(this.rate == undefined || this.rate === null) {
      filterC.rate = 0;
    } else {
      filterC.rate = this.rate;
    }

    this.doctorService.loadAllDoctors(filterC).subscribe((data) => {
      this.filteredDoctors = data;
    });
  }

  public selectDoctor(id: number) {
    let i;
    for (i = 0; i < this.filteredDoctors.length; i++) {
      if (this.filteredDoctors[i].id == id) {
        this.selectedDoctor = this.filteredDoctors[i];
        console.log(this.selectedDoctor);
      }
    }
  }

  public proceed() {
    //dodaj da mora termin umesto tipa da bude obavezan
    if(this.date == null || this.date==undefined || this.date.toString()==="" || !this.selectedDoctor.hasOwnProperty('id')) {
      alert('You must select doctor and choose date!');
      return;
    }

    console.log(this.selectedDoctor);
    this.router.navigate( ['reservation', this.selectedDoctor.id],{queryParams: { date: this.date , type: this.type }});
  }


}
