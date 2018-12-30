import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { Additionalservice } from 'src/app/model/Additionalservice';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-hotel-additional-services',
  templateUrl: './hotel-additional-services.component.html',
  styleUrls: ['./hotel-additional-services.component.css']
})
export class HotelAdditionalServicesComponent implements OnInit {

  @Input() hotel : Hotel;
  additionalServices : Additionalservice[];

  addAdditionalService() {
    alert('brao');
  }

  editAdditionalService(additionalService) {
    alert(additionalService.id);
  }

  deleteAdditionalService(additionalService) {
    alert(additionalService.id);
  }

  constructor(private hotelService : HotelService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.additionalServices = this.hotel.pricelistDTO.additionalServicesDTO;
  }

}
