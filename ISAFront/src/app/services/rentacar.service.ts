import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RentacarService {

  constructor(private http : HttpClient) { }

  getAllRentacars() : Observable<any> {
    return this.http.get('//localhost:8080/api/rentacars/all');
  }

  getRentacarById(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/rentacars/' + id);
  } 
}
