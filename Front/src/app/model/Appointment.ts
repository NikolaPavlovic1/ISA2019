import { Doctor } from './Doctor';
import { Time } from '@angular/common';

export class Appointment{
    id : number;
    appointment : Date;
    doctor : Doctor = new Doctor();
    reserved : boolean;
}