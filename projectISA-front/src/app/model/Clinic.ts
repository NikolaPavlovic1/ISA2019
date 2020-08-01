import { User } from './User';
import { Address } from './Address';

export class Clinic {
    id : number;
    doctors: User[] = [];
    address: Address;
    name : String;
}