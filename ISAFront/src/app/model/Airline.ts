import { Flight } from 'src/app/model/Flight';
import { Destination } from './Destination';

export class Airline { 
    id: number;
    name: string;
    address: string;
    description: string;    
    image: string;
    destinations: Array<Destination>;
  }