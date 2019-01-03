import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable,of, from } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdditionalserviceService {

  constructor(private http : HttpClient) { }

  getAllAdditionalServices() : Observable<any> {
    return this.http.get('//localhost:8080/api/additionalservices/all');
  }

  getAdditionalServiceById(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/additionalservices/' + id);
  }

  getAdditionalSevricesByPricelistId(id) : Observable<any> {
    return this.http.get('//localhost:8080/api/additionalservices/allbypricelist/' + id);
  }

  deleteAdditionalService(id) : Observable<any> {
    return this.http.delete('//localhost:8080/api/additionalservices/delete/' + id);
  }

  addAdditionalService(id, additionalService) : Observable<any> {
    return this.http.post('//localhost:8080/api/additionalservices/add/' + id, additionalService);
  }

  editAdditionalService(additionalService) : Observable<any> {
    return this.http.put('//localhost:8080/api/additionalservices/edit/' + additionalService.id, additionalService);
  }

  
}
