import { Hotel } from 'src/app/model/Hotel';
import { Additionalservice } from 'src/app/model/Additionalservice';

export class Pricelist { 
    id: number;
    hotel: Hotel;
    additionalServicesDTO: Additionalservice[];
  }