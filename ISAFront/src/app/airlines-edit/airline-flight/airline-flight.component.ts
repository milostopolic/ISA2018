import { Component, OnInit, Input } from '@angular/core';
import { Flight } from 'src/app/model/Flight';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Airline } from 'src/app/model/Airline';
import { Stop } from 'src/app/model/Stop';
import { FormControl } from '@angular/forms';
import { $ } from 'protractor';

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
  flag:boolean = false;
  checked:boolean = false;
  departurePlace = new FormControl("");
  destination = new FormControl("");
  takeOffDate = new FormControl("");
  takeOffTime = new FormControl("");
  landDate = new FormControl("");
  landTime = new FormControl("");
  distance = new FormControl("");
  stops = new FormControl("");
  price = new FormControl("");
  //flig : Flight = new Flight();
  temp2 :Flight = new Flight();
  flig_temp : Flight[] = [];
  stop_list: Stop[] = [];
  stop_temp = [];

  /*fillStops(stops){
    this.temp = "";
    for(let stop of stops){
      this.temp += stop + ", ";
    }
    this.temp = this.temp.substring(0, this.temp.length-2);
    //alert(this.temp);
    return this.temp;
  }*/



  saveChanges(){
    /*var temps = document.getElementsByName("stop");
    for(let i=0; i<temps.length; i++){
      if(temps[i].hasAttribute("checked")){
        alert(temps[i]);
      }
    }*/
    var flig : Flight = new Flight();
    flig.departurePlace = this.departurePlace.value;
    flig.destination = this.destination.value;
    flig.takeOffDate = this.takeOffDate.value;
    flig.takeOffTime = this.takeOffTime.value;
    flig.landDate = this.landDate.value;
    flig.landTime = this.landTime.value;
    flig.distance = this.distance.value;
    flig.stops = this.stop_list;   /* za sad praznu listu stopova posalje */
    flig.price = this.price.value;
    
    this.airlineService.addFlightToAirline(this.id, flig).subscribe(data => {
      /*this.temp2 = data;
      this.flig_temp.push(this.temp2);*/
      this.flights.push(data);
    })


  }

  addFlight(){
    this.flag = true;
  }

  deleteFlight(flight){
    alert(flight.id);
    this.airlineService.deleteFlightFromAirline(flight.id).subscribe(data =>{
      
    })

    const index: number = this.flights.indexOf(flight);
    if (index !== -1) {
        this.flights.splice(index, 1);
    }
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
    this.airlineService.getAllStops().subscribe(data => {
       this.stop_list = data; });
  }

}
