import { Component, OnInit } from '@angular/core';
import { Airline } from 'src/app/model/Airline';
import { AirlineService } from 'src/app/services/airline.service';
import { Flight } from '../model/Flight';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-airlines',
  templateUrl: './airlines.component.html',
  styleUrls: ['./airlines.component.css']
})
export class AirlinesComponent implements OnInit {

  airlines: Airline[];
  flightSearch : Flight = new Flight();
  searchedFlights : Flight[] = [];
  takeOffDate = new FormControl('');
  landDate = new FormControl('');
  table_show:boolean = false;
  airlines_show:boolean = true;

  date = new FormControl(new Date());

  constructor(private airlineService : AirlineService) { }

  

  SearchFlights(){
    this.table_show = true;
    this.airlines_show = false;
    //if(this.flightSearch.departurePlace == "" || this.flightSearch.destination == "" || this.flightSearch.takeOffDate == "" || this.flightSearch.landDate == ""){}
    this.airlineService.getSearchedFlights(this.flightSearch).subscribe(data => {
    this.searchedFlights = data;
    for(let f of this.searchedFlights){
      f.airline = new Airline();
      this.airlineService.getAirlineById(f.airline_id).subscribe(data=>{  //za ispis imena aviokompanije
        var temp : Airline = data;
        f.airline = temp;
      })
    }
    });
  }

  Return(){
    this.table_show = false;
    this.airlines_show = true;
  }

  ngOnInit() {
    this.airlineService.getAllAirlines().subscribe(data => { this.airlines = data });
  }

}
