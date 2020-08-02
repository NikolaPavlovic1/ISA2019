import { MedicalExamination } from './MedicalExamination';

export class MedicalRoom {
    id:number;
    description:String;
    clinicId : number;
    medicalExaminations: MedicalExamination[] = [];
}