import { Component, OnInit, ViewChild, Directive, Input, Output, EventEmitter, ViewChildren, QueryList, HostListener } from '@angular/core';
import { AllCommunityModules } from '@ag-grid-community/all-modules';
import { User } from 'src/app/model/User';
import { StudentService } from 'src/app/service/student.service';
import { Student } from 'src/app/model/Student';
import { Clinic } from 'src/app/model/Clinic';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { MatSortModule, MatSort, Sort } from '@angular/material/sort';
import { ClinicService } from 'src/app/service/clinic.service';
import { Subscription } from 'rxjs';
import { SortService } from 'src/app/service/sort.service';


@Component({
  selector: 'app-clinic',
  templateUrl: './clinic.component.html',
  styleUrls: ['./clinic.component.css']
})

export class ClinicComponent implements OnInit {

  user: User = new User();
  students: Student[] = [];
  student: Student = new Student();
  clinics: Clinic[] = [];

  sortedData;

 
  constructor(private service: StudentService, private clinicService: ClinicService, private sortService: SortService) { 
    //this.sortedData = this.klinike.slice();
  }

  //displayedColumns: string[] = ['ime'];
  //dataSource = new MatTableDataSource(this.klinike);

  ngOnInit() {

    this.clinicService.getAllClinics().subscribe(
      data => {
        this.clinics = data;
        this.sortedData=this.clinics;
      },
      error => {
        console.log(error);
      }
    )


  }

  sortData(sort: Sort) {
    const data = this.clinics.slice();
    if (!sort.active || sort.direction == '') {
      this.sortedData = data;
      return;
    }

    this.sortedData = data.sort((a, b) => {
      let isAsc = sort.direction == 'asc';
      switch (sort.active) {
        case 'id': return compare(a.id, b.id, isAsc);
        case 'name': return compareString(a.name, b.name, isAsc);
        case 'address': return compareString(a.address, b.address, isAsc);
        case 'description': return compareString(a.description, b.description, isAsc);
        case 'city': return compareString(a.city, b.city, isAsc);
        default: return 0;
      }
    });
  }

}

function compare(a: number, b: number, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

function compareString(a: string, b: string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

