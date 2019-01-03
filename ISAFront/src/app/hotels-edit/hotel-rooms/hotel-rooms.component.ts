import { Component, OnInit, Input } from '@angular/core';
import { Hotel } from 'src/app/model/Hotel';
import { Room } from 'src/app/model/Room';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute } from '@angular/router';
import { FormControl } from '@angular/forms';
import { RoomService } from 'src/app/services/room.service';

@Component({
  selector: 'app-hotel-rooms',
  templateUrl: './hotel-rooms.component.html',
  styleUrls: ['./hotel-rooms.component.css']
})
export class HotelRoomsComponent implements OnInit {
  
  @Input() hotel : Hotel;
  rooms : Room[];
  editingRoom : Room = new Room();
  deletingRoom : Room = new Room();

  beds = new FormControl("");
  price = new FormControl("");

  resetInputs() {
    this.beds.setValue("");
    this.price.setValue("");
  }

  addRoom() {
    var newRoom = new Room();
    newRoom.beds = this.beds.value;
    newRoom.price = this.price.value;

    this.roomService.addRoom(this.hotel.id, newRoom).subscribe(data => {this.rooms.push(data)});

    this.beds.setValue("");
    this.price.setValue("");
  }

  setEditingRoom(room) {
    this.editingRoom = room;
    this.beds.setValue(this.editingRoom.beds);
    this.price.setValue(this.editingRoom.price);
  }

  editRoom() {
    this.editingRoom.beds = this.beds.value;
    this.editingRoom.price = this.price.value;

    this.roomService.editRoom(this.editingRoom).subscribe(data => {});

    this.beds.setValue("");
    this.price.setValue("");
  }

  setDeletingRoom(room) {
    this.deletingRoom = room;
  }

  deleteRoom() {
    this.roomService.deleteRoom(this.deletingRoom.id).subscribe(data => {});

    const index: number = this.rooms.indexOf(this.deletingRoom);
    if (index !== -1) {
        this.rooms.splice(index, 1);
    }
  }
  
  constructor(private roomService : RoomService, private router : ActivatedRoute) { }

  ngOnInit() {
    this.rooms = this.hotel.roomsDTO;
    this.deletingRoom.id = -1;
    this.editingRoom.id = -1;
  }

}
