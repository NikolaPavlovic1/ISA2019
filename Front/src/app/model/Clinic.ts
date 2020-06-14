import { Doctor } from './Doctor';
import { Examination } from './Examination';

export class Clinic{
    id : number;
    name : string = "";
    address : string = "";
    description : string = "";
    doctors : Doctor[]=[];
    examinations : Examination[]=[];
    city: string="";
    rating: number;
}