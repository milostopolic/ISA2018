import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';
import { Rentacar } from '../model/Rentacar';



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


  search (name: string): Observable <Rentacar> {
    const url = `//localhost:8080/api/rentacars/filter/$ {name}`;
    return this.http.get <Rentacar> (url);
  }


}
