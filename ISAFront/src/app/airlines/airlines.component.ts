import { Component, OnInit } from '@angular/core';
import { Airline } from 'src/app/model/Airline';
import { AirlineService } from 'src/app/services/airline.service';

@Component({
  selector: 'app-airlines',
  templateUrl: './airlines.component.html',
  styleUrls: ['./airlines.component.css']
})
export class AirlinesComponent implements OnInit {

  airlines: Airline[];

  constructor(private airlineService : AirlineService) { }

  
  ngOnInit() {
    this.airlineService.getAllAirlines().subscribe(data => { this.airlines = data });
  }

}
