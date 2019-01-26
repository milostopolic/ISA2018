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

  date = new FormControl(new Date());

  constructor(private airlineService : AirlineService) { }

  SearchFlights(){
    /*var temp : string = this.takeOffDate.value;
    var temp2 : string = this.landDate.value;
    temp = temp.slice(1, temp.length-14);
    temp2 = temp2.slice(1, temp.length-14);
    this.flightSearch.takeOffDate = temp;
    this.flightSearch.landDate = temp2;*/
    //alert(this.flightSearch.takeOffDate.toString().substr(0,15));
    //this.flightSearch.takeOffDate = this.flightSearch.takeOffDate.toString().substr(0,14);
    //this.flightSearch.landDate = this.flightSearch.landDate.slice(1,-this.flightSearch.landDate.length-14);
    this.airlineService.getSearchedFlights(this.flightSearch).subscribe(data => {
      this.searchedFlights = data;
    });
    alert(this.searchedFlights.length);
  }

  ngOnInit() {
    this.airlineService.getAllAirlines().subscribe(data => { this.airlines = data });
  }

}
