import { User } from './User';
import { Address } from './Address';
import { MedicalRoom } from './MedicalRoom';
import { PricelistItem } from './PricelistItem';

export class Clinic {
    id : number;
    doctors: User[] = [];
    address: Address;
    name : String;
    description : String;
    appointments : Date[] = [];
    medicalRooms : MedicalRoom[] = [];
    pricelist : PricelistItem[] = [];
    avgClinicRate: number;
}