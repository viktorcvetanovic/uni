import {Component, ElementRef, OnDestroy, OnInit, QueryList, ViewChildren} from '@angular/core';
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {AppointmentScheduleService} from "../../assets/service/appointment_schedule/appointment-schedule.service";
import {LoggedInUserService} from "../../assets/service/logged-in-user/logged-in-user.service";
import {AppointmentSchedule} from "../../assets/@types/AppointmentSchedule";
import {AuthenticationService} from "../../assets/service/auth/authentication.service";
import AppointmentScheduleStatusEnum = AppointmentSchedule.AppointmentScheduleStatusEnum;
import {Confirmation} from "../../assets/decorators/confirmation.decorator";

@Component({
  selector: 'app-newsfeed',
  templateUrl: './newsfeed.component.html',
  styleUrls: ['./newsfeed.component.scss']
})
export class NewsfeedComponent implements OnInit, OnDestroy {

  @ViewChildren("newsItem", {read: ElementRef}) scroller!: QueryList<ElementRef>;
  items: AppointmentSchedule[] = [];
  currentIndex = 0;
  private mainInterval: any;
  isAdmin!: boolean;
username = this.authService.decodedAccessToken.user;
  constructor(private dialog: MatDialog,
              private appointmentScheduleService: AppointmentScheduleService,
              private loggedInUser: LoggedInUserService,
              private authService: AuthenticationService,
  ) {
  }

  ngOnInit() {
    this.isAdmin = this.authService.isAdmin();
    this.getAllAppointmentSchedule();
  }

  getAllAppointmentSchedule() {
    if (this.authService.isAdmin()) {
      this.appointmentScheduleService.getAllAppointmentSchedule().subscribe(data => {
        if (data) {
          this.items = data;
          if (screen.width >= 1050) {
            this.startNewsFeed();
          }
        }
      })
    } else {
      this.loggedInUser.getLoggedInUser(this.username).subscribe(user => {
        this.appointmentScheduleService.getAllAppointmentScheduleByUserId(user.id).subscribe(data => {
          if (data) {
            this.items = data;
            if (screen.width >= 1050) {
              this.startNewsFeed();
            }
          }
        })
      });
    }
  }

  startNewsFeed() {
    if (screen.width < 1050 || this.scroller.length <= 0) {
      return;
    }
    this.stopNewsFeed();
    this.mainInterval = setInterval(() => {
      if (this.currentIndex++ > this.scroller.length - 1) {
        this.currentIndex = 0;
      }
      this.scroller.get(this.currentIndex)?.nativeElement.scrollIntoView();
    }, 3000);
  }

  stopNewsFeed() {
    if (screen.width < 1050) {
      return;
    }
    clearInterval(this.mainInterval);
  }

  ngOnDestroy(): void {
    this.stopNewsFeed();
  }

  @Confirmation("Do you want?")
  changeStatus(appointmentSchedule: AppointmentSchedule, status: AppointmentScheduleStatusEnum) {
    appointmentSchedule.status = status;
    this.appointmentScheduleService.updateAppointmentSchedule(appointmentSchedule).subscribe(() => {
    });
  }
}
