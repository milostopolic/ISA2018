import { Rentacar } from 'src/app/model/Rentacar';

export class Vehicle { 
    id: number;
    manufacturer: string;
    model: string;
    productionyear: number; 
    seats: number;
    vehicletype: VehicleType;
    price: number;
    rentacar: Rentacar;    
  }

  enum VehicleType {
    HATCHBACK, SEDAN, SUV, COUPE
}