import {LOCALE_ID, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {CalendarComponent} from './calendar/calendar.component';
import {CalendarModule, DateAdapter} from "angular-calendar";
import {adapterFactory} from "angular-calendar/date-adapters/date-fns";
import {MaterialModule} from "./material.module";
import {MAT_DATE_LOCALE, MATERIAL_SANITY_CHECKS} from "@angular/material/core";
import {MatDialogRef} from "@angular/material/dialog";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {
  FacebookLoginProvider,
  GoogleLoginProvider,
  SocialAuthService,
  SocialAuthServiceConfig
} from "angularx-social-login";
import {JwtInterceptor} from "../assets/service/auth/jwt.interceptor";
import {CookieService} from "ngx-cookie-service";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {SnackbarService} from "../assets/service/snackbar/snackbar-handler";
import {AppRoutingModule} from "./app-routing.module";
import { SidebarComponent } from './sidebar/sidebar.component';
import { ProfileComponent } from './profile/profile.component';
import { NewsfeedComponent } from './newsfeed/newsfeed.component';
import { PinnedNewsfeedPipe } from '../assets/pipes/pinned-newsfeed.pipe';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DashboardDialogComponent } from './dashboard/dashboard-dialog/dashboard-dialog.component';
import { CalendarDialogComponent } from './calendar/calendar-dialog/calendar-dialog.component';
import { ConfirmationDialogComponent } from './confirmation-dialog/confirmation-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    CalendarComponent,
    SidebarComponent,
    ProfileComponent,
    NewsfeedComponent,
    PinnedNewsfeedPipe,
    DashboardComponent,
    DashboardDialogComponent,
    CalendarDialogComponent,
    ConfirmationDialogComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    ReactiveFormsModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    // NgxMatDatetimePickerModule,
    // NgxMatMomentModule,
    CalendarModule.forRoot({
      provide: DateAdapter,
      useFactory: adapterFactory
    })
  ],
  providers: [
    SnackbarService,
    CookieService,
    SocialAuthService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    // {provide: LOCALE_ID, useValue: 'sr-Latn'},
    {provide: MAT_DATE_LOCALE, useValue: "sr"},
    {provide: MatDialogRef, useValue: {}},
    {provide: MATERIAL_SANITY_CHECKS, useValue: false},
    {
      provide: 'SocialAuthServiceConfig',
      useValue: {
        autoLogin: false,
        providers: [
          {
            id: FacebookLoginProvider.PROVIDER_ID,
            provider: new FacebookLoginProvider("282577308941815")
          },
          {
            id: GoogleLoginProvider.PROVIDER_ID,
            provider: new GoogleLoginProvider("1016994148249-cvijokf575kprvsj6899n1ms5a213uu4.apps.googleusercontent.com")
          },
        ]
      } as SocialAuthServiceConfig,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
