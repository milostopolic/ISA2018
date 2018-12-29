import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';

@Component({
  selector: 'app-hotel-additional-services',
  templateUrl: './hotel-additional-services.component.html',
  styleUrls: ['./hotel-additional-services.component.css']
})
export class HotelAdditionalServicesComponent implements OnInit {

  @Input() hotel : Hotel;

  constructor() { }

  ngOnInit() {
  }

}
