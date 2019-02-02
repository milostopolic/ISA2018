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

  getTest() :  Observable<any> {
    return this.http.get('http://localhost:8080/api/users/test',{responseType: 'text'});
  }

  getAllUsers() : Observable<any> {
    return this.http.get('http://localhost:8080/api/users/all');
  }

  updateUser(user:User) : Observable<any>{
    return this.http.put("http://localhost:8080/api/users/update/" + user.id, user);
  }

  newUser(user:User) : Observable<any> {
    return this.http.post("http://localhost:8080/api/users/newUser",user);
  }

  logProvera(user:User) : Observable<any> {

    return this.http.post("http://localhost:8080/api/users/logProvera",user,{responseType: 'text'});

  }


}
