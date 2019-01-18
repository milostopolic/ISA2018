import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';
import { User } from 'src/app/model/User';

@Injectable({
  providedIn: 'root'
})
export class FriendshipService {

  constructor(private http : HttpClient) { }

  getFriends(id) :Observable<any> {

    return this.http.get('//localhost:8080/api/friendship/'+id+'/friends');
  }

  getPendingRequests(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/friendship/'+id+'/pending');
  }

  getSuggestedFriends(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/friendship/'+id+'/suggested');
  }

  sendFriendRequest(sender_id,receiver_id) : Observable<any> {
    return this.http.get('//localhost:8080/api/friendship/sendRequest/'+sender_id+'/'+receiver_id);
  }

  acceptFriendRequest(receiver_id,sender_id) :Observable<any> {
   
    return this.http.get('//localhost:8080/api/friendship/accept/'+receiver_id+'/'+sender_id);
  }

  declineFriendRequest(receiver_id,sender_id) :Observable<any> {

    return this.http.get('//localhost:8080/api/friendship/decline/'+receiver_id+'/'+sender_id);
  }

  deleteFriend(receiver_id, sender_id) :Observable<any> {
    return this.http.delete('//localhost:8080/api/friendship/delete/'+receiver_id+'/'+sender_id);
  }
}
