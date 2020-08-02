import { Address } from './Address';
import { MedicalRecord } from './MedicalRecord';
import { MedicalExamination } from './MedicalExamination';

export class User {
    id : number;
	name : String;
    lastName : String;
	email: String;
	username: String;
	password: String;
	phoneNumber: String;
	insuranceNumber: String;
	address: Address = new Address();
	medicalRecord : MedicalRecord = new MedicalRecord();
	role : String;
	active : Boolean;
	approved: Boolean;
	doctorsScheduledExaminations : MedicalExamination[] = [];
	clinicId : number;
}