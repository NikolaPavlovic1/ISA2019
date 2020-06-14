import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { PatientComponent } from './components/patient/patient.component';
import { ProfileComponent } from './components/patient/profile/profile.component';
import { HistoryComponent } from './components/patient/history/history.component';
import { ClinicComponent } from './components/patient/clinic/clinic.component';
import { MedicalRecordComponent } from './components/patient/medical-record/medical-record.component';
import { HomePatientComponent } from './components/patient/home-patient/home-patient.component';
import { ExaminationComponent } from './components/patient/examination/examination.component';
import { ScheduledExaminationComponent } from './components/patient/scheduled-examination/scheduled-examination.component';
import { SchedulingExaminationComponent } from './components/patient/scheduling-examination/scheduling-examination.component';
import { AuthGuard } from './guards/AuthGuard';
import { PatientGuard } from './guards/PatientGuard';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomePageComponent },
  { path: 'login', component: LoginComponent, canActivate:[AuthGuard]},
  { path: 'registration', component: RegistrationComponent },
  {
    path: 'registered', component: PatientComponent, canActivate: [PatientGuard],
    children: [
      { path: '', redirectTo: 'homePatient',  pathMatch: 'full' },
      {path: 'homePatient', component: HomePatientComponent},
      {path: 'examinations', component: ExaminationComponent},
      {path: 'profile', component: ProfileComponent},
      {path: 'history', component: HistoryComponent},
      {path: 'clinic', component: ClinicComponent},
      {path: 'record', component: MedicalRecordComponent},
      {path: 'scheduledExaminations', component: ScheduledExaminationComponent},
      {path: 'scheduling', component: SchedulingExaminationComponent},
      {path: '**', redirectTo: 'homePatient'}
    ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
