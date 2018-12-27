import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './modules/material.module';

import { AppComponent } from './app.component';
import { ProfileService } from './services/profile.service';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfileEditComponent } from './profile/profile-edit/profile-edit.component';
import { ProfileFriendsComponent } from './profile/profile-friends/profile-friends.component';
import { HotelService } from './services/hotel.service';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';
import { HotelsComponent } from './hotels/hotels.component';
import { HotelComponent } from './hotel/hotel.component';
import { AirlinesComponent } from './airlines/airlines.component';
import { AirlineService } from './services/airline.service';
import { AirlineComponent } from './airline/airline.component';
import { RentacarService } from './services/rentacar.service';
import { RentacarsComponent } from './rentacars/rentacars.component';
import { RentacarComponent } from './rentacar/rentacar.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AirlinesEditComponent } from './airlines-edit/airlines-edit.component';
import { AirlineUpdateComponent } from './airlines-edit/airline-update/airline-update.component';
import { AirlineDestinationComponent } from './airlines-edit/airline-destination/airline-destination.component';
import { AirlineFlightComponent } from './airlines-edit/airline-flight/airline-flight.component';

const appRoutes: Routes = [
  { path: 'profile/:id', component: ProfileComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomepageComponent },
  { path: 'hotels', component: HotelsComponent },
  { path: 'hotels/:id', component: HotelComponent },
  { path: 'airlines', component: AirlinesComponent },
  { path: 'airlines/:id', component: AirlineComponent },
  { path: 'rentacars', component: RentacarsComponent },
  { path: 'airlines/admin/:id', component: AirlinesEditComponent},
  { path: 'rentacars/:id', component: RentacarComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ProfileEditComponent,
    ProfileFriendsComponent,
    HomepageComponent,
    NavbarComponent,
    HotelsComponent,
    HotelComponent,
    AirlinesComponent,
    AirlineComponent,
    RentacarsComponent,
    RentacarComponent,
    AirlinesEditComponent,
    AirlineUpdateComponent,
    AirlineDestinationComponent,
    AirlineFlightComponent,       
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [ProfileService, HotelService, AirlineService, RentacarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
