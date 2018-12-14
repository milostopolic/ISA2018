import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel/hotel.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {

  hotels : Array<any>;

  constructor(private hotelService : HotelService) { }

  ngOnInit() {
    this.hotelService.getAllHotels().subscribe(data => {this.hotels = data}, error => {console.log(error)});
  }

}
