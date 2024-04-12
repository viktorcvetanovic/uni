import {Component, DoCheck, OnInit} from '@angular/core';
import {InternalRouteLink} from "../assets/@types/InternalRouteLink";
import {routesAdmin, routesUser} from "./routes";
import {AuthenticationService} from "../assets/service/auth/authentication.service";
import {UserService} from "../assets/service/user/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, DoCheck {
  title = 'serengeti-appointment';
  links!: InternalRouteLink[];

  constructor(private auth: AuthenticationService, private userService: UserService) {

  }

  ngOnInit(): void {
  }

  ngDoCheck() {
    if (this.auth.isLoggedIn) {
      if (this.auth.isAdmin()) {
        this.links = routesAdmin;
      } else {
        this.links = routesUser
      }
    }
  }
}
