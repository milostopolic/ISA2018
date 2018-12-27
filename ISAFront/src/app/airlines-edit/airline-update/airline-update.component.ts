import { Component, OnInit, Input } from '@angular/core';
import { Airline } from 'src/app/model/Airline';
import { FormControl } from '@angular/forms';
import { AirlineService } from 'src/app/services/airline.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-airline-update',
  templateUrl: './airline-update.component.html',
  styleUrls: ['./airline-update.component.css']
})
export class AirlineUpdateComponent implements OnInit {

  id;
  @Input() airline : Airline;
  airline2: Airline = new Airline();
  destinations : Array<string>;
  airlineEdit : Airline = new Airline();

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

  fillValues(){
    this.airlineEdit.name = this.name.value;
    this.airlineEdit.description = this.description.value;
    this.airlineEdit.address = this.address.value;
  }

  setValues(){
    this.name.setValue(this.airline.name);
    this.address.setValue(this.airline.address);
    this.description.setValue(this.airline.description);
  }

  updateBtn(){
    this.fillValues();
    this.airlineEdit.id = this.airline.id;
    this.airlineService.updateAriline(this.airlineEdit).subscribe(response=>{
      this.airlineEdit = response;
      this.name.setValue(this.airlineEdit.name);
      this.address.setValue(this.airlineEdit.address);
      this.description.setValue(this.airlineEdit.description);
    })
    window.location.reload();
  }


  constructor(private airlineService : AirlineService, private router : ActivatedRoute ) { }

  ngOnInit() {
 
    this.setValues();
  }

}
