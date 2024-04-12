import {Component, Inject, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {Appointment} from "../../../assets/@types/Appointment";
import {formatDateA, formatDatee, getTimeFromISODateString, parseTime} from "../../../assets/util/dateUtil";
import {AppointmentService} from "../../../assets/service/appointment/appointment.service";

@Component({
  selector: 'app-dashboard-dialog',
  templateUrl: './dashboard-dialog.component.html',
  styleUrls: ['./dashboard-dialog.component.scss']
})
export class DashboardDialogComponent implements OnInit {
  form = new FormGroup({
    id: new FormControl(null, Validators.required),
    startTime: new FormControl(null, Validators.required),
    endTime: new FormControl(null, Validators.required),
    date: new FormControl(null, Validators.required),
    status: new FormControl(null)
  });
  appointment!: Appointment;
  date!: string;

  constructor(private dialogRef: MatDialogRef<DashboardDialogComponent>, @Inject(MAT_DIALOG_DATA) data: any, private service: AppointmentService) {
    this.appointment = data;
    if (this.appointment) {
      this.form.setValue(this.appointment);
    }
  }

  ngOnInit(): void {
  }



  saveAppointment() {
    this.appointment = this.form.value as Appointment;

    this.appointment.startTime = parseTime(this.appointment.startTime);
    this.appointment.endTime = parseTime(this.appointment.endTime);
    this.appointment.date = formatDateA(this.appointment.date);

    if (this.appointment.id) {
      this.service.updateAppointment(this.appointment).subscribe(() => {
        this.close();
      });
    } else {
      this.appointment.status = "CREATED";
      this.service.saveAppointment(this.appointment).subscribe(() => {
        this.close();
      });
    }
  }

  close() {
    this.dialogRef.close(true);
  }
}
