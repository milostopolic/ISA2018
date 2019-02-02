import { Component, OnInit } from '@angular/core';
import { Rentacar } from 'src/app/model/Rentacar';
import { FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { RentacarService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-rentacarsearch',
  templateUrl: './rentacarsearch.component.html',
  styleUrls: ['./rentacarsearch.component.css']
})
export class RentacarsearchComponent implements OnInit {

   // Control to search for users
   searchForm : FormGroup;

  

  proveri(){
   
    console.warn(this.searchForm.value);
    
  }

  constructor(private rentcarService : RentacarService,private formBuilder : FormBuilder) { }

  ngOnInit() {
    
    this.searchForm = this.formBuilder.group({
      pickUpLocation : [],
      dropOffLocation : [],
      pickUpDate : [],
      dropOffDate : [],
      pickUpTime :[],
      dropOffTime : [],
      numberOfPassengers : [],
      carType : []

    });

}
}