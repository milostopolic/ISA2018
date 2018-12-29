import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';

@Component({
  selector: 'app-hotel-update',
  templateUrl: './hotel-update.component.html',
  styleUrls: ['./hotel-update.component.css']
})
export class HotelUpdateComponent implements OnInit {

  @Input() hotel : Hotel;

  constructor() { }

  ngOnInit() {
  }

}
