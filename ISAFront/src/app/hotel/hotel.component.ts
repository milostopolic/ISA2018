import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from 'src/app/model/Hotel';
import { HotelService } from 'src/app/services/hotel.service';
import { Room } from 'src/app/model/Room';
import { Pricelist } from 'src/app/model/Pricelist';
import { Additionalservice } from 'src/app/model/Additionalservice';
import { AdditionalserviceService } from 'src/app/services/additionalservice.service';
import { DomSanitizer } from '@angular/platform-browser';

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
  address = "";

  additionalServices: Additionalservice[];

  constructor(private hotelService:HotelService, private additionalServiceService: AdditionalserviceService, private router:ActivatedRoute, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.hotelService.getHotelById(this.id).subscribe(data => {
       this.hotel = data;
       console.log(this.hotel);
       this.dataSource =  data.roomsDTO;
       //this.additionalServices = this.additionalServiceService.getAdditionalSevricesByPricelistId(this.hotel.pricelist.id);
       this.additionalServices = this.hotel.pricelistDTO.additionalServicesDTO;
       
       var address = this.hotel.address.replace(/ /g, '%20');


       this.address += "https://maps.google.com/maps?q="+address+"&t=&z=13&ie=UTF8&iwloc=&output=embed";

       console.log(address);
       console.log(this.additionalServices);
      });   
      
  }

}
