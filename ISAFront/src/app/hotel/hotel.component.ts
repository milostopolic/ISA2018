import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from 'src/app/model/Hotel';
import { HotelService } from 'src/app/services/hotel.service';
import { Room } from 'src/app/model/Room';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {

  id;
  hotel: Hotel = new Hotel();
  displayedColumns: string[] = ['beds', 'price', 'book'];
  dataSource: Room[];

  constructor(private hotelService:HotelService,private router:ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.hotelService.getHotelById(this.id).subscribe(data => { this.hotel = data; this.dataSource =  data.roomsDTO});   
    
  }

}
