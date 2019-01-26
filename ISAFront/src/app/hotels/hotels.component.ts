import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { Hotel } from 'src/app/model/Hotel';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent implements OnInit {

  hotels: Hotel[] = [];
  name = new FormControl("");
  address = new FormControl("");

  search() {
    if(this.name.value != "" && this.address.value == "") {
      console.log("TRAZIM PO IMENU");
      this.hotelService.searchHotelByName(this.name.value).subscribe(data => { this.hotels = []; this.hotels.push(data) });      
    } else if(this.address.value != "" && this.name.value == ""){       
        console.log("TRAZIM PO ADRESI");
        this.hotelService.searchHotelsByAddress(this.address.value).subscribe(data => { this.hotels = data });      
    }
  }
  

  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    this.hotelService.getAllHotels().subscribe(data => { this.hotels = data});
  }

}
