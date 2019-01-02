import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { Additionalservice } from 'src/app/model/Additionalservice';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute } from '@angular/router';
import { AdditionalserviceService } from 'src/app/services/additionalservice.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-hotel-additional-services',
  templateUrl: './hotel-additional-services.component.html',
  styleUrls: ['./hotel-additional-services.component.css']
})
export class HotelAdditionalServicesComponent implements OnInit {

  @Input() hotel : Hotel;
  additionalServices : Additionalservice[];
  editingAS : Additionalservice = new Additionalservice();
  deletingAS : Additionalservice = new Additionalservice();
  
  name = new FormControl("");
  price = new FormControl("");

  addAdditionalService() {
    alert('brao, ' + this.name.value + this.price.value);
  }

  editAdditionalService(additionalService) {
    this.editingAS = additionalService;
    alert(this.editingAS.id);
  }

  setDeletingAS(additionalService) {
    this.deletingAS = additionalService;    
  }

  deleteAdditionalService() {
    this.additionalServiceService.deleteAdditionalService(this.deletingAS.id).subscribe(data => {});

    const index: number = this.additionalServices.indexOf(this.deletingAS);
    if (index !== -1) {
        this.additionalServices.splice(index, 1);
    }
  }

  constructor(private additionalServiceService : AdditionalserviceService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.additionalServices = this.hotel.pricelistDTO.additionalServicesDTO;
    this.deletingAS.id = -1;
    this.deletingAS.name = "";
    this.editingAS.id = -1;
    this.editingAS.name = "";
  }

}
