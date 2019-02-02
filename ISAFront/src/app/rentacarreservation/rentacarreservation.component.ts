import { Component, OnInit } from '@angular/core';
import { Rentacar } from '../model/Rentacar';
import  {RentacarService} from '../services/rentacar.service';
import { Router } from '@angular/router';
import { RentacarsearchComponent } from '../rentacarreservation/rentacarsearch/rentacarsearch.component';

@Component({
  selector: 'app-rentacarreservation',
  templateUrl: './rentacarreservation.component.html',
  styleUrls: ['./rentacarreservation.component.css']
})
export class RentacarreservationComponent implements OnInit {
  

  rentacarId : number;
  rentacars : Rentacar[] ;
  selectedDay: string = '';


  
  selectChangeHandler (event: any) {
   
    this.rentacarId = this.rentacars.find(x=>x.name == event.target.value).id;
    this.router.navigate(["rentacars/"+this.rentacarId]);
  }
  

  constructor( private rentService : RentacarService , private router : Router) { }

  ngOnInit() {
  
    this.rentService.getAllRentacars().subscribe(data => this.rentacars=data);
    
   
  }



}
