import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { ActivatedRoute } from '@angular/router';
import { User } from '../model/User';
import { FriendshipService } from '../services/friendship.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  id;
  user:User = new User();
  profile_show:boolean = true;
  friends_show:boolean = false;
  constructor(private profileService:ProfileService, private router:ActivatedRoute, private friendshipService:FriendshipService) { }

  show_friends(){
    this.profile_show = false;
    this.friends_show = true;
  }

  show_profile(){
    this.profile_show = true;
    this.friends_show = false;
  }

  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    this.profileService.getUserById(this.id).subscribe(shke=>{
      this.user = shke;
      this.friendshipService.getFriends(this.user.id).subscribe(data=>{
        this.user.friends = data;        
      });
      this.friendshipService.getPendingRequests(this.user.id).subscribe(data=>{
        this.user.pending = data;       
      });
      this.friendshipService.getSuggestedFriends(this.user.id).subscribe(data=>{
        this.user.suggested = data;       
      });

    },error=>{
      console.log(error);
    });
  }

}
