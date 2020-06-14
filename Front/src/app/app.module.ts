import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AgGridModule } from '@ag-grid-community/angular';
import { ModalModule } from 'ngx-bootstrap/modal';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PatientComponent } from './components/patient/patient.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { LoginComponent } from './components/login/login.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ProfileComponent } from './components/patient/profile/profile.component';
import { ClinicComponent } from './components/patient/clinic/clinic.component';
import { MedicalRecordComponent } from './components/patient/medical-record/medical-record.component';
import { HistoryComponent } from './components/patient/history/history.component';
import { HomePatientComponent } from './components/patient/home-patient/home-patient.component';
import { ExaminationComponent } from './components/patient/examination/examination.component';
import { AuthInterceptor } from './http-interceptor/AuthInterceptor';
import { AuthService } from './service/AuthService';
import { DatePipe, CommonModule } from '@angular/common';
import { ScheduledExaminationComponent } from './components/patient/scheduled-examination/scheduled-examination.component';
import { MatTableModule, MatSortModule } from '@angular/material';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SchedulingExaminationComponent } from './components/patient/scheduling-examination/scheduling-examination.component';


@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    RegistrationComponent,
    LoginComponent,
    HomePageComponent,
    ProfileComponent,
    ClinicComponent,
    MedicalRecordComponent,
    HistoryComponent,
    HomePatientComponent,
    ExaminationComponent,
    ScheduledExaminationComponent,
    SchedulingExaminationComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatTableModule,
    ReactiveFormsModule,
    CommonModule,
    MatSortModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgbModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    ModalModule.forRoot(),
    AgGridModule.withComponents([])
  ],
  providers: [
    DatePipe,
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }],
  exports: [AppComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
