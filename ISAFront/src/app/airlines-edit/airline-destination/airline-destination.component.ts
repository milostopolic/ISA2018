import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';
import { Airline } from 'src/app/model/Airline';
import { FormControl } from '@angular/forms';
import { Destination } from 'src/app/model/Destination';

@Component({
  selector: 'app-airline-destination',
  templateUrl: './airline-destination.component.html',
  styleUrls: ['./airline-destination.component.css']
})
export class AirlineDestinationComponent implements OnInit {
  id;
  @Input() airline : Airline;
  destinations : Array<Destination>;
  flag:boolean = false;
  destination = new FormControl("");
  destinationEdit = new FormControl("");
  destinations_temp : Destination[] = [];
  dest : Destination = new Destination();

  addDestination(){
    this.flag = true;
  }

  temp:Destination = new Destination();

  saveChanges(){
    this.dest.name = this.destination.value;

    this.airlineService.addDestinationToAirline(this.id,this.dest).subscribe(data => {
      this.temp = data;
        this.destinations_temp.push(this.temp);
    })
      
  }

  deleteDestination(destination){
    alert(destination.id);
    this.airlineService.deleteDestinationFromAirline(destination.id).subscribe(data =>{
      
    })

    const index: number = this.destinations_temp.indexOf(destination);
    if (index !== -1) {
        this.destinations_temp.splice(index, 1);
    } 
  }
  tempDest:Destination = new Destination();
  tempString: string = ""; //koristim da zapamtim staru vrednost pa je u erroru vratim.
  fillValues(destination){
    this.tempDest = destination;
    this.tempString += destination.name;
    this.destinationEdit.setValue(this.tempDest.name);
  }

  changedDestination:Destination = new Destination();
  editDestination(){
    this.tempDest.name = this.destinationEdit.value;
    this.airlineService.editDestinationFromAirline(this.tempDest).subscribe(data => {
    this.changedDestination = data;
    this.tempDest.name = this.changedDestination.name;
    },error =>  { 
      this.tempDest.name = this.tempString; 
      alert("Ime vec postoji");
      console.log(error);
      return;
    })
  }

  constructor(private airlineService : AirlineService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.airlineService.getAirlineById(this.id).subscribe(data => { 
        this.airline = data; 
        this.destinations = data.destinations;
        for(let d of this.destinations){
          this.destinations_temp.push(d);
        }
    });


  }

}
