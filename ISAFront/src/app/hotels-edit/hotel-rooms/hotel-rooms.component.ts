import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';

@Component({
  selector: 'app-hotel-rooms',
  templateUrl: './hotel-rooms.component.html',
  styleUrls: ['./hotel-rooms.component.css']
})
export class HotelRoomsComponent implements OnInit {
  
  @Input() hotel : Hotel;
  
  constructor() { }

  ngOnInit() {
  }

}
