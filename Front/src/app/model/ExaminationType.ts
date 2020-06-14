import { Doctor } from './Doctor';
import { Clinic } from './Clinic';

export class ExaminationType{
    id : number;
    name: string="";
    price : number;
    doctors : Doctor[] =[];
    clinics : Clinic[] =[];
}