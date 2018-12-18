import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/User';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http:HttpClient) { }
  getUserById(id):Observable<any>{
    return this.http.get("http://localhost:8080/api/users/" + id);
  }

  updateUser(user:User) : Observable<any>{
    return this.http.put("http://localhost:8080/api/users/update/" + user.id, user);
  }
}
