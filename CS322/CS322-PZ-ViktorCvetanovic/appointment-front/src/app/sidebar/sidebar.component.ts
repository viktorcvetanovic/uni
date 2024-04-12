import {ChangeDetectorRef, Component, DoCheck, Input, OnInit} from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {MatDrawerMode} from "@angular/material/sidenav";
import {Router} from "@angular/router";
import {AuthenticationService} from "../../assets/service/auth/authentication.service";
import {InternalRouteLink} from "../../assets/@types/InternalRouteLink";


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit, DoCheck {
  modeValue: MatDrawerMode = "side";
  opened = true; // Da li je 'side-nav' otvoren
  blockUpdate = false; // Pomocna promenljiva koja resava bug koji ima 'side-nav'
  notifications: Notification[] = [];
  _links: InternalRouteLink[] = [];
  showSidebarText = true;
  roles: any[] = [];
  @Input() hasTheme = false;
  isLoggedIn!: boolean;


  constructor(private cdref: ChangeDetectorRef, private auth: AuthenticationService, public router: Router, private dialog: MatDialog, private authService: AuthenticationService) {
  }

  ngOnInit() {
    window.dispatchEvent(new Event("resize"));
  }

  ngDoCheck(): void {
    this.isLoggedIn = this.authService.isLoggedIn;
    this.opened = this.isLoggedIn;
  }

  @Input()
  get links(): InternalRouteLink[] {
    return this._links;
  }

  set links(links: InternalRouteLink[]) {
    if (links?.length > 0) {
      this._links = links;
    }
  }

  ngAfterContentChecked() {
    this.cdref.detectChanges();
  }

  isAdmin() {
    return this.auth.isAdmin();
  }

  onResize(event: any) {
    if (this.blockUpdate) {
      this.blockUpdate = false;
      return;
    }
    if (event.target.innerWidth > 1280) {
      this.modeValue = "side";
      this.opened = true;
    } else if (event.target.innerWidth <= 1280 && event.target.innerWidth > 480) {
      this.opened = true;
      this.modeValue = "side";
    } else if (event.target.innerWidth <= 480) {
      this.opened = false;
      this.modeValue = "over";
    }
  }

  logout() {
    this.authService.logout();
    this.authService.logOut();
  }

  triggerResizeEvent() {
    window.dispatchEvent(new Event("resize"));
  }

}
