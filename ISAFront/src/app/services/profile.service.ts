import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http:HttpClient) { }
  getUserById(id):Observable<any>{
    return this.http.get("http://localhost:1234/api/users/" + id);
  }
}
