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

const appRoutes: Routes = [
  { path: 'profile/:id', component: ProfileComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    ProfileNavComponent,
    ProfileEditComponent,
    ProfileFriendsComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [ProfileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
