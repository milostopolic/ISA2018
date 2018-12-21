import { Component, OnInit, Input } from '@angular/core';
import { Airline } from 'src/app/model/Airline';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Flight } from 'src/app/model/Flight';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-airlines-edit',
  templateUrl: './airlines-edit.component.html',
  styleUrls: ['./airlines-edit.component.css']
})
export class AirlinesEditComponent implements OnInit {

  id;
  airline: Airline = new Airline();
  flights: Flight[];
  temp : string = "";
  name = new FormControl("");
  description = new FormControl("");
  address = new FormControl("");

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
    alert(flight.destination);
  }

  editFlight(flight){
    alert(flight.destination);
  }

  constructor(private airlineService : AirlineService, private router : ActivatedRoute ) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.airlineService.getAirlineById(this.id).subscribe(data => { this.airline = data; this.flights = data.flightsDTO; });

  }

}
