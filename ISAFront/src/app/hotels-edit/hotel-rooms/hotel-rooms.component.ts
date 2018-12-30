import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { Room } from 'src/app/model/Room';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-hotel-rooms',
  templateUrl: './hotel-rooms.component.html',
  styleUrls: ['./hotel-rooms.component.css']
})
export class HotelRoomsComponent implements OnInit {
  
  @Input() hotel : Hotel;
  rooms : Room[];  

  addRoom() {
    alert('brao');
  }

  editRoom(room) {
    alert(room.id);
  }

  deleteRoom(room) {
    alert(room.id);
  }
  
  constructor(private hotelService : HotelService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.rooms = this.hotel.roomsDTO;
    console.log(this.rooms);
  }

}
