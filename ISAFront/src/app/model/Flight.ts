import { Airline } from 'src/app/model/Airline';

export class Flight { 
    id: number;
    departurePlace: string;
    destination: string;
    takeOffDate: string;
    takeOffTime: string;
    landDate: string;
    landTime: string;
    distance: number;
    stops: Array<string>[];
    airline: Airline;
    price: number;    
  }