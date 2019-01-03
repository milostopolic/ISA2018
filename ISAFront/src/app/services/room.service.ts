import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {

  constructor(private http : HttpClient) { }

getRoomById(id) : Observable<any> {
  return this.http.get('//localhost:8080/api/rooms/' + id);
}

deleteRoom(id) : Observable<any> {
  return this.http.delete('//localhost:8080/api/rooms/delete/' + id);
}

addRoom(id, room) : Observable<any> {
  return this.http.post('//localhost:8080/api/room/add/' + id, room);
}

editRoom(room) : Observable<any> {
  return this.http.put('//localhost:8080/api/rooms/edit/' + room.id, room);
}

}
