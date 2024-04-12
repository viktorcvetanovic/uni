import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {RegisterComponent} from "./register/register.component";
import {CalendarComponent} from "./calendar/calendar.component";
import {ProfileComponent} from "./profile/profile.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {LoginAuthGuard} from "../assets/service/auth/login-auth.guard";
import {AuthGuard} from "../assets/service/auth/auth.guard";

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
    canActivate: [LoginAuthGuard]
  },
  {
    path: 'home',
    component: ProfileComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: 'appointment',
    component: CalendarComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: 'login',
    component: LoginComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  // {
  //   path: 'profile',
  //   component: ProfileComponent
  // },
  {
    path: "",
    redirectTo: "",
    pathMatch: "full"
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
