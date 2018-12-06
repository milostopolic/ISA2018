import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user/User';
import { ProfileService } from 'src/app/services/profile.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css']
})
export class ProfileEditComponent implements OnInit {

  id;
  user:User = new User();
  constructor(private profileService:ProfileService, private router:ActivatedRoute) { }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.profileService.getUserById(this.id).subscribe(shke=>{
      this.user = shke;
    },error=>{
      console.log(error);
    });
  }

}
