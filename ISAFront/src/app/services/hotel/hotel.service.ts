import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HotelService {

  constructor(private http : HttpClient) { }

  getAllHotels() : Observable<any> {
    return this.http.get('//localhost:1212/api/hotels/all');
  }
}
