import { Room } from 'src/app/model/Room';
import { Pricelist } from 'src/app/model/Pricelist';

export class Hotel { 
    id: number;
    name: string;
    address: string;
    description: string;    
    image: string;
    pricelistDTO: Pricelist;
  }