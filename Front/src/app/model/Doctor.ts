import { Examination } from './Examination';
import { Appointment } from './Appointment';

export class Doctor{
    id : number;
    name : string = "";
    surname : string = "";
    rating : number;
    examinations : Examination[]=[];
    workingTimeFrom: Date;
    workingTimeTo: Date;
    vacationFrom: Date;
    vacationTo: Date;
    appointments : Appointment[]=[];
}