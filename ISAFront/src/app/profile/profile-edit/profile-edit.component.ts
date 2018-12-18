import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/app/model/User';
import { ProfileService } from 'src/app/services/profile.service';
import { ActivatedRoute } from '@angular/router';
import { FormControl } from '@angular/forms';
import { fillProperties } from '@angular/core/src/util/property';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  @Input()user : User;
  userEdit : User = new User();
  name = new FormControl("");
  surname = new FormControl("");
  phoneNmbr = new FormControl("");
  address = new FormControl("");

  fillValues(){
    this.userEdit.name = this.name.value;
    this.userEdit.surname = this.surname.value;
    this.userEdit.phoneNmbr = this.phoneNmbr.value;
    this.userEdit.city = this.address.value;
  }

  fill(){
    this.name.setValue(this.user.name);
    this.surname.setValue(this.user.surname);
    this.phoneNmbr.setValue(this.user.phoneNmbr);
    this.address.setValue(this.user.city);
  }

  updateBtn(){
    this.fillValues();
    this.userEdit.id = this.user.id;
    this.profileService.updateUser(this.userEdit).subscribe(response=>{
      window.location.reload();
    })
  }

  constructor(private profileService:ProfileService, private router:ActivatedRoute) { }

  ngOnInit() {
    this.fill();

  }

}
