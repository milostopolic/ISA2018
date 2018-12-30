import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { FormControl } from '@angular/forms';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-hotel-update',
  templateUrl: './hotel-update.component.html',
  styleUrls: ['./hotel-update.component.css']
})
export class HotelUpdateComponent implements OnInit {

  @Input() hotel : Hotel;
  hotelEdit : Hotel = new Hotel();

  name = new FormControl("");
  address = new FormControl("");
  description = new FormControl("");

  fillValues() {
    this.hotelEdit.name = this.name.value;
    this.hotelEdit.address = this.address.value;
    this.hotelEdit.description = this.description.value;
  }

  setValues() {
    this.name.setValue(this.hotel.name);
    this.address.setValue(this.hotel.address);
    this.description.setValue(this.hotel.description);
  }

  updateBtn() {
    this.fillValues();
    this.hotelEdit.id = this.hotel.id;
    this.hotelService.updateHotel(this.hotelEdit).subscribe(response => {
      this.hotelEdit = response;
      this.name.setValue(this.hotelEdit.name);
      this.address.setValue(this.hotelEdit.address);
      this.description.setValue(this.hotelEdit.description);
    });
    //window.location.reload();
  }

  constructor(private hotelService : HotelService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.setValues();
  }

}
