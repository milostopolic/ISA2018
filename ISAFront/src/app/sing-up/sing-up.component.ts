import { Component, OnInit } from '@angular/core';
import {Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import {User } from '../model/User';
import { ProfileService } from '../services/profile.service';

@Component({
  selector: 'app-sing-up',
  templateUrl: './sing-up.component.html',
  styleUrls: ['./sing-up.component.css']
})
export class SingUpComponent implements OnInit {
  signUpForm : FormGroup;
  poruka : "";
  
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
  role: '',
  friends: [],
  pending: [],
  suggested: []
 }

  constructor( private formBuilder : FormBuilder, private router : Router, private profileService : ProfileService) { }

  ngOnInit() {

    this.signUpForm = this.formBuilder.group({
      'name' : [this.user.name, [Validators.required]],
      'surname' : [this.user.surname , [Validators.required]],
      'email' : [this.user.email , [Validators.required]],
      'city' : [this.user.city, [Validators.required]],
      'username' : [this.user.username,[Validators.required]],
      
      'password' : [this.user.password, [Validators.required]],
      'phoneNmbr':  [this.user.phoneNmbr, [Validators.required]]

    });

  }


  proveri() {
  this.profileService.newUser(this.signUpForm.value).subscribe( data => this.poruka=data);

  }
}
