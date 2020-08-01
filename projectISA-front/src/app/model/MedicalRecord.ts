import { User } from './User';
import { Disease } from './Disease';

export class MedicalRecord {
    id : number;
    userId: User;
    diseaseHistory: Disease[] = [];
}