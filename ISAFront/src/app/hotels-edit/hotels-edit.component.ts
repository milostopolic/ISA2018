import { Component, OnInit } from '@angular/core';
import { Hotel } from '../model/Hotel';
import { HotelService } from '../services/hotel.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-hotels-edit',
  templateUrl: './hotels-edit.component.html',
  styleUrls: ['./hotels-edit.component.css']
})
export class HotelsEditComponent implements OnInit {

  id;
  hotel: Hotel = new Hotel();

  hotel_show : boolean = true;
  rooms_show : boolean = false;
  additionalServices_show : boolean = false;

  show_hotel() {
    this.hotel_show = true;
    this.rooms_show = false;
    this.additionalServices_show = false;
  }

  show_rooms() {
    this.hotel_show = false;
    this.rooms_show = true;
    this.additionalServices_show = false;
  }

  show_additionalServices() {
    this.hotel_show = false;
    this.rooms_show = false;
    this.additionalServices_show = true;
  }

  constructor(private hotelService : HotelService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.hotelService.getHotelById(this.id).subscribe(data => { this.hotel = data });
  }

}
