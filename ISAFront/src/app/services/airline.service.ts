import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';
import { Airline } from '../model/Airline';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'text/plain' })
};

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

  updateAirline(airline:Airline) : Observable<any> {
    alert(airline.name);
    return this.http.put('//localhost:8080/api/airlines/update/' + airline.id, airline);
  }

  addDestinationToAirline(id,destination) : Observable<any>{
    return this.http.post('//localhost:8080/api/airlines/addDestination/' + id, destination);
  }

  deleteDestinationFromAirline(id) : Observable<any>{
    return this.http.delete('//localhost:8080/api/airlines/deleteDestination/' + id);
  }

  editDestinationFromAirline(destination) : Observable<any>{
    return this.http.put('//localhost:8080/api/airlines/editDestination/' + destination.id, destination);
  }

}
 