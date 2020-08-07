import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AdminUserComponent } from './components/admin-user/admin-user.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { ClinicComponent} from "./components/clinic/clinic.component";
import { ClinicsComponent} from "./components/clinics/clinics.component";
import { HistoryComponent} from "./components/history/history.component";
import { MedicalRecordComponent} from "./components/medical-record/medical-record.component";
import {DoctorsComponent} from "./components/doctors/doctors.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";
import { FinalReservationComponent } from './components/final-reservation/final-reservation.component';

const routes: Routes = [
  { path: "home", component: HomeComponent },
  {path:'', redirectTo:'/home', pathMatch:'full'} ,
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "users", component: AdminUserComponent },
  { path: "clinics", component: ClinicsComponent },
  { path: "clinic/:id", component: ClinicComponent },
  { path: "doctors/:idClinic", component: DoctorsComponent },
  { path: "history", component: HistoryComponent },
  { path: "medical-record", component: MedicalRecordComponent },
  { path: "profile", component: UserProfileComponent },
  { path: "reservation", component: FinalReservationComponent },
  {path:'**', component:PageNotFoundComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
