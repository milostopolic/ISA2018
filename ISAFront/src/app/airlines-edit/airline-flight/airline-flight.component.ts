import { Component, OnInit, Input } from '@angular/core';
import { Flight } from 'src/app/model/Flight';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Airline } from 'src/app/model/Airline';

@Component({
  selector: 'app-airline-flight',
  templateUrl: './airline-flight.component.html',
  styleUrls: ['./airline-flight.component.css']
})
export class AirlineFlightComponent implements OnInit {
  id;
  @Input() airline : Airline;
  flights: Flight[];
  temp : string = "";

  fillStops(stops){
    this.temp = "";
    for(let stop of stops){
      this.temp += stop + ", ";
    }
    this.temp = this.temp.substring(0, this.temp.length-2);
    //alert(this.temp);
    return this.temp;
  }

  deleteFlight(flight){
    alert(flight.id);
  }

  editFlight(flight){
    alert(flight.id);
  }

  constructor(private airlineService : AirlineService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.airlineService.getAirlineById(this.id).subscribe(data => { 
        this.airline = data; 
        this.flights = data.flightsDTO; 
    });
  }

}
