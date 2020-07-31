import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AdminUserComponent } from './components/admin-user/admin-user.component';
import { UserProfileComponent } from './components/user-profile/user-profile.component';
import { ClinicsComponent} from "./components/clinics/clinics.component";
import { HistoryComponent} from "./components/history/history.component";
import { MedicalRecordComponent} from "./components/medical-record/medical-record.component";



const routes: Routes = [
  { path: "home", component: HomeComponent },
  { path: "login", component: LoginComponent },
  { path: "register", component: RegisterComponent },
  { path: "users", component: AdminUserComponent },
  { path: "clinics", component: ClinicsComponent },
  { path: "history", component: HistoryComponent },
  { path: "medical-record", component: MedicalRecordComponent },
  { path: "profile", component: UserProfileComponent },
  { path: "", component: HomeComponent },
  {path:'', redirectTo:'/home', pathMatch:'full'} 
  //{path:'**', component:PageNotFoundComponent} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
