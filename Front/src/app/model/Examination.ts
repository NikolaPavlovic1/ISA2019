import { Doctor } from './Doctor';
import { Clinic } from './Clinic';
import { ExaminationType } from './ExaminationType';
import { Time } from '@angular/common';
import { Appointment } from './Appointment';

export class Examination{
    id : number;
    price : number;
    discount : number;
    typeOfExamination : ExaminationType=new ExaminationType();
    hall : number;
    duration : number;
    appointment : Date;
    time : Date;
    doctor : Doctor = new Doctor();
    medium : string="";
    status : string="";
    clinic : Clinic = new Clinic();
    new : number;
    tempTime : Appointment = new Appointment();
}