import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';
import { Airline } from '../model/Airline';
import { Flight } from '../model/Flight';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'text/plain' })
};

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  constructor(private http : HttpClient) { }

  /** ------------ Airline servisi ---------- */

  getAllAirlines() : Observable<any> {
    return this.http.get('//localhost:8080/api/airlines/all');
  }

  getAirlineById(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/airlines/' + id);
  }

  updateAirline(airline:Airline) : Observable<any> {
    alert(airline.name);
    return this.http.put('//localhost:8080/api/airlines/update/' + airline.id, airline);
  }

  /** ------------ Destination servisi ---------- */
  
  addDestinationToAirline(id,destination) : Observable<any>{
    return this.http.post('//localhost:8080/api/airlines/addDestination/' + id, destination);
  }

  deleteDestinationFromAirline(id) : Observable<any>{
    return this.http.delete('//localhost:8080/api/airlines/deleteDestination/' + id);
  }

  editDestinationFromAirline(destination) : Observable<any>{
    return this.http.put('//localhost:8080/api/airlines/editDestination/' + destination.id, destination);
  }


  /** ------------ Flight servisi ---------- */

  addFlightToAirline(id,flight) : Observable<any>{
    return this.http.post('//localhost:8080/api/airlines/addFlight/' + id, flight);
  }

  deleteFlightFromAirline(id) : Observable<any>{
    return this.http.delete('//localhost:8080/api/airlines/deleteFlight/' + id);
  }

  editFlightFromAirline(flight) : Observable<any>{
    return this.http.put('//localhost:8080/api/airlines/editFlight/' + flight.id, flight);
  }

  getSearchedFlights(flight : Flight) : Observable<any> {
    alert(flight.destination);
    return this.http.post('//localhost:8080/api/airlines/searchFlights', flight);
  }

  /** ------------ Stop servisi ---------- */

  getAllStops() : Observable<any> {
    return this.http.get('//localhost:8080/api/airlines/allStops');
  }



}
 