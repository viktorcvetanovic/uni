import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {FormControl, FormGroup} from "@angular/forms";
import {formatDateB, formatDatee, getTimeFromISODateString} from "../../../assets/util/dateUtil";
import {Appointment} from "../../../assets/@types/Appointment";
import {AppointmentService} from "../../../assets/service/appointment/appointment.service";
import {AppointmentScheduleService} from "../../../assets/service/appointment_schedule/appointment-schedule.service";
import {AppointmentSchedule} from "../../../assets/@types/AppointmentSchedule";
import {User} from "../../../assets/@types/User";
import {Confirmation} from "../../../assets/decorators/confirmation.decorator";
import {LoggedInUserService} from "../../../assets/service/logged-in-user/logged-in-user.service";
import {AuthenticationService} from "../../../assets/service/auth/authentication.service";

@Component({
  selector: 'app-calendar-dialog',
  templateUrl: './calendar-dialog.component.html',
  styleUrls: ['./calendar-dialog.component.scss']
})
export class CalendarDialogComponent implements OnInit {
  appointmentId!: number;
  dateTime!: { startTime: string, endTime: string };
  action!: "Point" | "Day";
  user!: User;
  date!: string;
  appointmentList: Appointment[] = [];
  appointmentListStatusIsNull: AppointmentSchedule[] = [];
  form = new FormGroup({
    start: new FormControl(null),
    end: new FormControl(null)
  });
  username = this.authService.decodedAccessToken.user;

  constructor(private dialogRef: MatDialogRef<CalendarDialogComponent>,
              @Inject(MAT_DIALOG_DATA) data: any,
              private dialog: MatDialog,
              private appointmentService: AppointmentService,
              private authService: AuthenticationService,
              private appointmentScheduleService: AppointmentScheduleService,
              private loggedInUserService: LoggedInUserService,
  ) {
    if (data != null) {
      if (data.action === "Point") {
        this.appointmentId = data.event.id;
      } else if (data.action === "Day") {
        // this.userId = data.id;
        this.date = formatDateB(data.date);
      }
      this.action = data.action;
    }
  }

  ngOnInit(): void {
    this.loggedInUserService.getLoggedInUser(this.username).subscribe(user => {
      this.user = user;
      if (this.action === "Point") {
        this.getAppointmentById();
      }
      if (this.action === "Day") {
        this.getAllAppointmentByDate();
      }
    });
  }

  getAppointmentById(): void {
    this.appointmentService.getAppointmentById(this.appointmentId).subscribe(data => {
      this.dateTime = data;
    });
  }

  getAllAppointmentByDate(): void {
    this.appointmentService.getAllAppointmentByDate(this.date).subscribe(data => {
      this.appointmentList = data;
    });
    this.appointmentScheduleService.getAllByUserIdAndAppointmentDateAndStatusIsNull(this.user.id, this.date).subscribe(data => {
      this.appointmentListStatusIsNull = data;
    })
  }

  getTimeFromISODateString(date: any) {
    return getTimeFromISODateString(date).substring(0, 5);
  }

  @Confirmation("Do you want?")
  scheduleAppointment(appointment: Appointment) {
    appointment.status = "ORDERED";
    let appointmentSchedule: any;
    this.appointmentService.updateAppointment(appointment).subscribe(appointment => {
      appointmentSchedule = {
        appointmentFk: appointment.id,
        userFk: this.user.id,
      };


      this.appointmentScheduleService.saveAppointmentSchedule(appointmentSchedule).subscribe(() => {
        this.getAllAppointmentByDate()
      })
    })
  }

  @Confirmation("Do you want?")
  deleteScheduleAppointment(appointmentSchedule: AppointmentSchedule) {
    appointmentSchedule.appointment.status = "CANCELED";
    this.appointmentService.updateAppointment(appointmentSchedule.appointment).subscribe(() => {
      this.appointmentScheduleService.deleteAppointmentSchedule(appointmentSchedule.id).subscribe(() => {
        this.getAllAppointmentByDate()
      });
    })
  }
}
