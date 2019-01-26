import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';
import { Hotel } from '../model/Hotel';


@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http : HttpClient) { }

  getAllHotels() : Observable<any> {
    return this.http.get('//localhost:8080/api/hotels/all');
  }

  getHotelById(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/hotels/' + id);
  } 

  updateHotel(hotel: Hotel) : Observable<any> {
    return this.http.put('//localhost:8080/api/hotels/update/' + hotel.id, hotel);
  }

  searchHotelByName(name) : Observable<any> {
    return this.http.get('//localhost:8080/api/hotels/searchbyname/' + name);
  }

  searchHotelsByAddress(address) : Observable<any> {
    return this.http.get('//localhost:8080/api/hotels/searchbyaddress/' + address);
  }
}
