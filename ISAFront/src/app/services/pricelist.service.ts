import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PricelistService {

  constructor(private http : HttpClient) { }

  getAllPricelists() : Observable<any> {
    return this.http.get('//localhost:8080/api/pricelists/all');
  }

  getPricelistById(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/pricelists/' + id);
  }
  
}
