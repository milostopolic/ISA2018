import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {MatNativeDateModule, DateAdapter, MAT_DATE_FORMATS, MatFormFieldModule, MatInputModule, MatAutocompleteModule} from '@angular/material';
import {MatMomentDateModule, MAT_MOMENT_DATE_ADAPTER_OPTIONS, MAT_MOMENT_DATE_FORMATS} from '@angular/material-moment-adapter';
import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { Moment } from 'moment';
import * as moment from 'moment';

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
import { HotelsEditComponent } from './hotels-edit/hotels-edit.component';
import { HotelUpdateComponent } from './hotels-edit/hotel-update/hotel-update.component';
import { HotelRoomsComponent } from './hotels-edit/hotel-rooms/hotel-rooms.component';
import { HotelAdditionalServicesComponent } from './hotels-edit/hotel-additional-services/hotel-additional-services.component';
import { DatePipe } from '@angular/common';
import { FriendshipComponent } from './model/friendship/friendship.component';
import { NgAisModule } from 'angular-instantsearch';
import { Filter_friends_pipe } from './profile/profile-friends/filter_friends/filter_friends.pipe';
import { MAT_DATE_LOCALE } from '@angular/material';
import { MomentUtcDateAdapter } from './date/MomentUtcDateAdapter';
import {NgxMaterialTimepickerModule} from 'ngx-material-timepicker';
import { LoginComponent } from './login/login.component';
import { SingUpComponent } from './sing-up/sing-up.component';
import { RentAdminComponent } from './rent-admin/rent-admin.component';
import { RentacarreservationComponent } from './rentacarreservation/rentacarreservation.component';
import { RentacarsearchComponent } from './rentacarreservation/rentacarsearch/rentacarsearch.component';

const appRoutes: Routes = [
  { path: 'profile/:id', component: ProfileComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomepageComponent },
  { path: 'hotels', component: HotelsComponent },
  { path: 'hotels/:id', component: HotelComponent },
  { path: 'hotels/admin/:id', component: HotelsEditComponent },
  { path: 'airlines', component: AirlinesComponent },
  { path: 'airlines/:id', component: AirlineComponent },
  { path: 'rentacars', component: RentacarsComponent },
  { path: 'airlines/admin/:id', component: AirlinesEditComponent},
  { path: 'rentacars/:id', component: RentacarComponent },
  { path: 'login', component: LoginComponent},
  { path: 'signup', component: SingUpComponent},
  { path: 'rentAdmin',component: RentAdminComponent},
  { path: 'rentReservation' , component : RentacarreservationComponent}
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
    HotelsEditComponent,
    HotelUpdateComponent,
    HotelRoomsComponent,
    HotelAdditionalServicesComponent,
    FriendshipComponent,     
    Filter_friends_pipe, LoginComponent, SingUpComponent, RentAdminComponent, RentacarreservationComponent, RentacarsearchComponent,  
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    NgxMaterialTimepickerModule.forRoot(),
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    ),
    NgAisModule.forRoot()
  ],
  providers: [ProfileService, HotelService, AirlineService, RentacarService, DatePipe, {provide : MAT_DATE_LOCALE,useValue:'en-GB'},{provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS}, { provide: DateAdapter, useClass: MomentUtcDateAdapter } ],
  bootstrap: [AppComponent]
})
export class AppModule { }
