import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/User';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

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
