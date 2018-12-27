import { Component, OnInit, Input } from '@angular/core';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Airline } from 'src/app/model/Airline';

@Component({
  selector: 'app-airline-destination',
  templateUrl: './airline-destination.component.html',
  styleUrls: ['./airline-destination.component.css']
})
export class AirlineDestinationComponent implements OnInit {
  id;
  @Input() airline : Airline;
  destinations : Array<string>;


  deleteDestination(destination){
    alert(destination);
  }

  editDestination(destination){
    alert(destination);
  }

  constructor(private airlineService : AirlineService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.airlineService.getAirlineById(this.id).subscribe(data => { 
        this.airline = data; 
        this.destinations = data.destinations;
    });
  }

}
