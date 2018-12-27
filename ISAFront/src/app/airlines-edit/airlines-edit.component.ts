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
  airline:Airline = new Airline();

  airline_show:boolean = true;
  destination_show:boolean = false;
  flight_show:boolean = false;

  show_destination(){
    this.airline_show = false;
    this.destination_show = true;
    this.flight_show = false;
  }

  show_flight(){
    this.airline_show = false;
    this.destination_show = false;
    this.flight_show = true;
  }

  show_airline(){
    this.airline_show = true;
    this.destination_show = false;
    this.flight_show = false;
  }

  constructor(private airlineService : AirlineService, private router : ActivatedRoute ) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.airlineService.getAirlineById(this.id).subscribe(data => { 
        this.airline = data; 
    });
  }

}
