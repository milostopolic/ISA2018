import { Component, OnInit } from '@angular/core';
import {Rentacar } from '../model/Rentacar';
import { RentacarService} from '../services/rentacar.service';
import { FormGroup,FormBuilder, Validators } from '@angular/forms';
import { Pipe, PipeTransform } from '@angular/core';


@Component({
  selector: 'app-rent-admin',
  templateUrl: './rent-admin.component.html',
  styleUrls: ['./rent-admin.component.css']
})
export class RentAdminComponent implements OnInit {

  nameForm:FormGroup;
  

  constructor(private formBuilder : FormBuilder,private rentService:RentacarService) { }

  ngOnInit() {

    this.nameForm = this.formBuilder.group({
      id: [],
     
      name : [],
      address: [],
      description : []
      
    });


      this.rentService.getRentacarById(1).subscribe(carService => (
          this.nameForm.controls['id'].setValue(carService.id),
          this.nameForm.controls['name'].setValue(carService.name),
          this.nameForm.controls['address'].setValue(carService.address),
          this.nameForm.controls['description'].setValue(carService.description)

      ));

  }


  togle(){


  }

}
