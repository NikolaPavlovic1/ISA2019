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
    ClinicComponent
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