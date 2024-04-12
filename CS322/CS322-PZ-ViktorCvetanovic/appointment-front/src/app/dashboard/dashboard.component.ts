import {Component, OnInit, ViewChild} from '@angular/core';
import {MatSort} from "@angular/material/sort";
import {MatPaginator} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {DashboardDialogComponent} from "./dashboard-dialog/dashboard-dialog.component";
import {AppointmentService} from "../../assets/service/appointment/appointment.service";
import {Confirmation} from "../../assets/decorators/confirmation.decorator";
import {UserService} from "../../assets/service/user/user.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  appointments: any[] = [];
  displayedColumns: string[] = ["startTime", "endTime", "date", "actions"];
  @ViewChild(MatPaginator, {static: false}) paginator!: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort!: MatSort;
  dataSource!: MatTableDataSource<any>;

  constructor(private dialog: MatDialog, private appointmentService: AppointmentService, private userService: UserService) {
  }

  ngOnInit(): void {
    this.getAllAppointment();
  }

  openDialog(appointment: any) {
    let dialogConfig = new MatDialogConfig();
    dialogConfig.width = "auto";
    dialogConfig.data = appointment;
    this.dialog.open(DashboardDialogComponent, dialogConfig).afterClosed().subscribe(data => {
      if (data) {
        this.getAllAppointment();
      }
    });
  }

  getAllAppointment() {
    this.appointmentService.getAllAppointment().subscribe(data => {
      this.appointments = data;
      this.dataSource = new MatTableDataSource<any>(this.appointments);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
  }

  @Confirmation()
  deleteAppointment(id: number) {
    this.appointmentService.deleteAppointment(id).subscribe(() => {
      this.getAllAppointment();
    })
  }
}
