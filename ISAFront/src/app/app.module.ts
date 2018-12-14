import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'

import { AppComponent } from './app.component';
import { ProfileService } from './services/profile.service';
import { ProfileComponent } from './profile/profile.component';
import { HttpClientModule } from '@angular/common/http';
import { ProfileNavComponent } from './profile/profile-nav/profile-nav.component';
import { ProfileEditComponent } from './profile/profile-edit/profile-edit.component';
import { ProfileFriendsComponent } from './profile/profile-friends/profile-friends.component';
import { NavbarComponent } from './homepage/navbar/navbar.component';
import { IndexComponent } from './homepage/index/index.component';
import { CardsComponent } from './homepage/cards/cards.component';
import { HotelService } from './services/hotel/hotel.service';

const appRoutes: Routes = [
  { path: 'profile/:id', component: ProfileComponent },
  { path: 'home', component: IndexComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ProfileNavComponent,
    ProfileEditComponent,
    ProfileFriendsComponent,
    NavbarComponent,
    IndexComponent,
    CardsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [ProfileService, HotelService],
  bootstrap: [AppComponent]
})
export class AppModule { }
