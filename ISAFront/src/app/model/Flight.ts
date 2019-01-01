import { Airline } from 'src/app/model/Airline';
import { Stop } from 'src/app/model/Stop';

export class Flight { 
    id: number;
    departurePlace: string;
    destination: string;
    takeOffDate: string;
    takeOffTime: string;
    landDate: string;
    landTime: string;
    distance: number;
    stops: Array<Stop>;
    airline: Airline;
    price: number;    
  }