import { Component, OnInit, Input } from '@angular/core';
import { UseExistingWebDriver } from 'protractor/built/driverProviders';
import { User } from 'src/app/model/User';
import { FriendshipService } from 'src/app/services/friendship.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile-friends',
  templateUrl: './profile-friends.component.html',
  styleUrls: ['./profile-friends.component.css']
})
export class ProfileFriendsComponent implements OnInit {

  @Input()profile: User;
  id;
  friends_list:User[] = [];
  pending_list:User[] = [];
  suggested_list:User[] = [];
  typed : string = "";

  constructor(private friendshipService:FriendshipService, private router:ActivatedRoute) { }

  AcceptFriendRequest(sender){
    this.friendshipService.acceptFriendRequest(this.id,sender.id).subscribe(data=>{
      this.friends_list.push(sender);
      const index: number = this.pending_list.indexOf(sender);
      if (index !== -1) {
        this.pending_list.splice(index, 1);
      } 
      })
  }

  DeclineFriendRequest(sender){
    this.friendshipService.declineFriendRequest(this.id,sender.id).subscribe(data=>{
      const index: number = this.pending_list.indexOf(sender);
      if (index !== -1) {
        this.pending_list.splice(index, 1);
      } 
    })
  }

  DeleteFriend(sender){
    this.friendshipService.deleteFriend(this.id,sender.id).subscribe(data=>{
      const index: number = this.friends_list.indexOf(sender);
      if (index !== -1) {
        this.friends_list.splice(index, 1);
      } 
    })
  }

  SendRequest(receiver){
    this.friendshipService.sendFriendRequest(this.id,receiver.id).subscribe(data=>{
      const index: number = this.suggested_list.indexOf(receiver);
      if (index !== -1) {
        this.suggested_list.splice(index, 1);
      } 
    })
  };

  HideSuggested(sender){
    
  }



  ngOnInit() {
    this.id = this.router.snapshot.params.id;
    for(let fr of this.profile.friends){
      this.friends_list.push(fr);
    }

    for(let pn of this.profile.pending){
      this.pending_list.push(pn);
    }

    for(let sg of this.profile.suggested){
      this.suggested_list.push(sg);
    }
  }

}
