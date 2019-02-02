import { Component, OnInit } from '@angular/core';
import { ProfileService } from '../services/profile.service';
import { Router }  from '@angular/router';
import { User } from '../model/User';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  
  user : User ={
    id: 15,
    email: "",
    password: "",
    name: "" ,
    surname: '',
    username : '',
    city: '',
    phoneNmbr: '',
    verified: true, 
    role :'',
    friends: [],
    pending: [],
    suggested: []
   }
  users : User[];
  logInForm : FormGroup;


  constructor( private profileService : ProfileService,private router : Router,private formBuilder : FormBuilder) { }

  ngOnInit() {

    this.logInForm = this.formBuilder.group({
     
      'username' : [this.user.username,[Validators.required]],
      
      'password' : [this.user.password, [Validators.required]]

    });

      }
    

proveriLogovanje(){
  this.profileService.logProvera(this.logInForm.value).subscribe(data => {

    switch (data) {
      case "rentAdmin":
          this.router.navigate(["/rentAdmin"]);
          break;
      case "user":
          console.log("user poruka");
          break;
      case "neuspesno": 
          console.log("neuspesno");
          break;
      default:
        console.log("defaultna poruka");
          //default block statement;
  }

  });
  
  
}

redirekcija(){
  

}


}
