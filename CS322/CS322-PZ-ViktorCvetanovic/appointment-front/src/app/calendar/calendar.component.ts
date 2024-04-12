import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {endOfDay, isSameDay, isSameMonth, startOfDay} from 'date-fns';
import {Subject} from 'rxjs';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {
  CalendarEvent,
  CalendarEventAction,
  CalendarEventTimesChangedEvent,
  CalendarMonthViewDay,
  CalendarView
} from 'angular-calendar';
import {AppointmentService} from "../../assets/service/appointment/appointment.service";
import {Appointment} from "../../assets/@types/Appointment";
import {getTimeFromISODateString} from "../../assets/util/dateUtil";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {CalendarDialogComponent} from "./calendar-dialog/calendar-dialog.component";


const colors: any = {
  red: {
    primary: '#ad2121',
    secondary: '#FAE3E3'
  },
  blue: {
    primary: '#1e90ff',
    secondary: '#D1E8FF'
  },
  green: {
    primary: '#2dc748',
    secondary: '#D1E8FF'
  },
  yellow: {
    primary: '#e3bc08',
    secondary: '#FDF1BA'
  }
};


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {

  @ViewChild('modalContent')
  modalContent!: TemplateRef<any>;

  appointments: Appointment[] = [];

  view: CalendarView = CalendarView.Month;

  CalendarView = CalendarView;

  viewDate: Date = new Date();

  // modalData: {
  //   action: string;
  //   event: CalendarEvent;
  // };

  actions: CalendarEventAction[] = [
    {
      label: '<i class="fa fa-fw fa-pencil"></i>',
      onClick: ({event}: { event: CalendarEvent }): void => {
        this.handleEvent('Edited', event);
      }
    },
    {
      label: '<i class="fa fa-fw fa-times"></i>',
      onClick: ({event}: { event: CalendarEvent }): void => {
        this.events = this.events.filter(iEvent => iEvent !== event);
        this.handleEvent('Deleted', event);
      }
    }
  ];

  refresh: Subject<any> = new Subject();

  events: CalendarEvent[] = [];

  activeDayIsOpen: boolean = true;

  constructor(private modal: NgbModal, private service: AppointmentService, private dialog: MatDialog) {
  }

  dayClicked({date, events}: { date: Date; events: CalendarEvent[] }, action: any): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.minWidth = "auto";
    dialogConfig.data = {
      action,
      date
    };
    this.dialog.open(CalendarDialogComponent, dialogConfig).afterClosed().subscribe(() => {
      this.getAllAppointments();
    });
    ``
    if (isSameMonth(date, this.viewDate)) {
      this.viewDate = date;
      this.activeDayIsOpen = !((isSameDay(this.viewDate, date) && this.activeDayIsOpen) || events.length === 0);
    }
  }

  pointEvent(action: string, event: CalendarEvent): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.minWidth = "auto";
    dialogConfig.data = {
      action,
      event,
    };

    this.dialog.open(CalendarDialogComponent, dialogConfig).afterClosed();
  }

  eventTimesChanged({
                      event,
                      newStart,
                      newEnd
                    }: CalendarEventTimesChangedEvent): void {
    event.start = newStart;
    event.end = newEnd;
    // this.handleEvent('Dropped or resized', event);
    this.refresh.next(null);
  }

  handleEvent(action: string, event: CalendarEvent): void {
    // this.modalData = { event, action };
    this.modal.open(this.modalContent, {size: 'lg'});
  }

  dateIsValid(date: Date): boolean {
    const today = new Date();
    today.setHours(0, 0, 0, 0)
    return date.getTime() < today.getTime();
  }

  applyDateSelectionPolicy({body}: { body: CalendarMonthViewDay[] }): void {
    body.forEach(day => {
      if (this.dateIsValid(day.date)) {
        day.cssClass = 'disabled-date';
      }
    });
  }


  getAllAppointments() {
    this.events = [];
    this.service.getAllAppointmentSchedule().subscribe(data => {
      this.appointments = data;
      this.appointments.forEach(appointmentSchedule => {
        this.events.push({
          id: appointmentSchedule.id,
          title: appointmentSchedule?.startTime + " - " +appointmentSchedule?.endTime,
          start: startOfDay(new Date(appointmentSchedule?.date.split("T")[0] + " " + appointmentSchedule?.startTime)),
          end: endOfDay(new Date(appointmentSchedule?.date.split("T")[0] + " " + appointmentSchedule?.endTime)),
          color: appointmentSchedule.status === "CANCELED" ? colors.green : colors.red,
          draggable: false,
          resizable: {
            beforeStart: true,
            afterEnd: true,
          },
        });
        this.refresh.next(null);
      });
    })
  }

  ngOnInit(): void {
    this.getAllAppointments()
  }
}
