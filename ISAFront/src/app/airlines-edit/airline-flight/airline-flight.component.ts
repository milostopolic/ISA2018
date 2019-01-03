import { Component, OnInit, Input } from '@angular/core';
import { Flight } from 'src/app/model/Flight';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Airline } from 'src/app/model/Airline';
import { Stop } from 'src/app/model/Stop';
import { FormControl } from '@angular/forms';
import { $ } from 'protractor';
import { DatePipe } from '@angular/common'
import { TouchSequence } from 'selenium-webdriver';

@Component({
  selector: 'app-airline-flight',
  templateUrl: './airline-flight.component.html',
  styleUrls: ['./airline-flight.component.css']
})
export class AirlineFlightComponent implements OnInit {
  id;
  @Input() airline : Airline;
  flights: Flight[];
  flag:boolean = false;
  

  departurePlace = new FormControl("");
  destination = new FormControl("");
  takeOffDate = new FormControl("");
  takeOffTime = new FormControl("");
  landDate = new FormControl("");
  landTime = new FormControl("");
  distance = new FormControl("");
  stops = new FormControl("");
  price = new FormControl("");

  editingFlight : Flight = new Flight();

  temp2 :Flight = new Flight();
  flig_temp : Flight[] = [];
  checked:boolean = false;

  stop_list: Stop[] = [];

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
    /*let latest_date = this.datepipe.transform(this.takeOffDate.value, 'yyyy-MM-dd');
    alert(latest_date);
    flig.takeOffDate = latest_date;*/
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

  fillValuesFlight(flight){
    this.editingFlight = flight;
    this.departurePlace.setValue(this.editingFlight.departurePlace);
    this.destination.setValue(this.editingFlight.destination);
    this.takeOffDate.setValue(this.editingFlight.takeOffDate);
    this.takeOffTime.setValue(this.editingFlight.takeOffTime);
    this.landDate.setValue(this.editingFlight.landDate);
    this.landTime.setValue(this.editingFlight.landTime);
    this.distance.setValue(this.editingFlight.distance);
    this.stops.setValue(this.editingFlight.stops);
    this.price.setValue(this.editingFlight.price);
 
  }

  editFlight(){
    this.editingFlight.departurePlace = this.departurePlace.value;
    this.editingFlight.destination = this.destination.value;
    this.editingFlight.takeOffDate = this.takeOffDate.value;
    this.editingFlight.takeOffTime = this.takeOffTime.value;
    this.editingFlight.landDate = this.landDate.value;
    this.editingFlight.landTime = this.landTime.value;
    this.editingFlight.distance = this.distance.value;
    this.editingFlight.stops = this.stops.value;
    this.editingFlight.price = this.price.value;


    this.airlineService.editFlightFromAirline(this.editingFlight).subscribe(data => {});

    this.departurePlace.setValue("");
    this.destination.setValue("");
    this.takeOffDate.setValue("");
    this.takeOffTime.setValue("");
    this.landDate.setValue("");
    this.landTime.setValue("");
    this.stops.setValue("");
    this.price.setValue("");
  }

  constructor(private airlineService : AirlineService, private router : ActivatedRoute, public datepipe: DatePipe) { }

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
