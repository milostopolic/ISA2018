import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './modules/material.module';

import { AppComponent } from './app.component';
import { ProfileService } from './services/profile.service';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfileNavComponent } from './profile/profile-nav/profile-nav.component';
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

const appRoutes: Routes = [
  { path: 'profile/:id', component: ProfileComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomepageComponent },
  { path: 'hotels', component: HotelsComponent },
  { path: 'hotels/:id', component: HotelComponent },
  { path: 'airlines', component: AirlinesComponent },
  { path: 'airlines/:id', component: AirlineComponent },
  { path: 'rentacars', component: RentacarService },
  { path: 'rentacars/:id', component: RentacarService }
];

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ProfileNavComponent,
    ProfileEditComponent,
    ProfileFriendsComponent,
    HomepageComponent,
    NavbarComponent,
    HotelsComponent,
    HotelComponent,
    AirlinesComponent,
    AirlineComponent,       
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [ProfileService, HotelService, AirlineService, RentacarService],
  bootstrap: [AppComponent]
})
export class AppModule { }
