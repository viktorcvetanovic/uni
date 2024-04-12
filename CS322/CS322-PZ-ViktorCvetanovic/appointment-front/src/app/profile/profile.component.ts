import {Component, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {LoggedInUserService} from "../../assets/service/logged-in-user/logged-in-user.service";
import {User} from "../../assets/@types/User";
import {Role} from "../../assets/@types/Role";
import {AuthenticationService} from "../../assets/service/auth/authentication.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  constructor(private dialog: MatDialog,
              private authService: AuthenticationService,
              private loggedInUserService: LoggedInUserService) {
  }

  user!: User;
  username = this.authService.decodedAccessToken.user;

  ngOnInit() {
    this.getUserInfo();
  }

  getUserInfo() {
    this.loggedInUserService.getLoggedInUser(this.username.toString()).subscribe(user => {
      this.user = user;
    })
  }

  renderRoleList(roles: Role[]) {
    if (!roles) {
      return;
    }
    return roles.map(role => role?.name).join();
  }
}
