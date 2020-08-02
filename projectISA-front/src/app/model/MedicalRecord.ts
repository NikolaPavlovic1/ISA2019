import { User } from './User';
import { Disease } from './Disease';
import { MedicalExamination } from './MedicalExamination';

export class MedicalRecord {
    id : number;
    userId: number;
    diseaseHistory: Disease[] = [];
    medicalExaminations: MedicalExamination[] = [];
}