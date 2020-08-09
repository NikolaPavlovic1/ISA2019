import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { AdminUserComponent } from './components/admin-user/admin-user.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { ClinicsComponent } from './components/clinics/clinics.component';
import { HistoryComponent } from './components/history/history.component';
import { MedicalRecordComponent } from './components/medical-record/medical-record.component';
import { DatePipe } from '@angular/common';
import { ClinicComponent } from './components/clinic/clinic.component';
import { DoctorsComponent } from './components/doctors/doctors.component';
import { FinalReservationComponent } from './components/final-reservation/final-reservation.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { AccountConfirmationComponent } from './components/account-confirmation/account-confirmation.component';
import { AdminExaminationComponent } from './components/admin-examination/admin-examination.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    LoginComponent,
    AdminUserComponent,
    UserProfileComponent,
    ClinicsComponent,
    HistoryComponent,
    MedicalRecordComponent,
    ClinicComponent,
    DoctorsComponent,
    FinalReservationComponent,
    PageNotFoundComponent,
    AccountConfirmationComponent,
    AdminExaminationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
