import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { Hotel } from 'src/app/model/Hotel';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  hotels: Hotel[];
  

  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    this.hotelService.getAllHotels().subscribe(data => { this.hotels = data});
  }

}
