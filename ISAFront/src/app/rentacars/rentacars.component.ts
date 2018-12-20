import { Component, OnInit } from '@angular/core';
import { Rentacar } from 'src/app/model/Rentacar';
import { RentacarService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-rentacars',
  templateUrl: './rentacars.component.html',
  styleUrls: ['./rentacars.component.css']
})
export class RentacarsComponent implements OnInit {

  rentacars: Rentacar[];

  constructor(private rentacarService: RentacarService) { }

  ngOnInit() {
    this.rentacarService.getAllRentacars().subscribe(data => { this.rentacars = data });    
  }

}
