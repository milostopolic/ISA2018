import { Component, OnInit } from '@angular/core';
import { Airline } from 'src/app/model/Airline';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Flight } from 'src/app/model/Flight';

@Component({
  selector: 'app-airline',
  templateUrl: './airline.component.html',
  styleUrls: ['./airline.component.css']
})
export class AirlineComponent implements OnInit {

  id;
  airline: Airline = new Airline();
  displayedColumns: string[] = ['departurePlace', 'destination', 'takeOffDate', 'takeOffTime', 'landDate', 'landTime', 'distance', 'stops', 'price', 'book'];
  dataSource: Flight[];

  constructor(private airlineService: AirlineService, private router: ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.airlineService.getAirlineById(this.id).subscribe(data => { this.airline = data; this.dataSource = data.flightsDTO });
  }

}
