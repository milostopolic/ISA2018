import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';
import { Airline } from '../model/Airline';

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  constructor(private http : HttpClient) { }

  getAllAirlines() : Observable<any> {
    return this.http.get('//localhost:8080/api/airlines/all');
  }

  getAirlineById(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/airlines/' + id);
  }

  updateAriline(airlines:Airline) : Observable<any> {
    alert(airlines.name);
    return this.http.put('//localhost:8080/api/airlines/update/' + airlines.id, airlines);
  }
}
 