import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {AppointmentSchedule} from "../../@types/AppointmentSchedule";

@Injectable({
  providedIn: 'root'
})
export class AppointmentScheduleService {

  constructor(private http: HttpClient) { }


  getAllAppointmentSchedule() {
    return this.http.get<AppointmentSchedule[]>(`${environment.baseUrl}/appointment-schedules/when-date-has-not-passed`);
  }

  updateAppointmentSchedule(appointmentSchedule: AppointmentSchedule) {
    return this.http.put<AppointmentSchedule>(`${environment.baseUrl}/appointment-schedules`, appointmentSchedule);
  }

  saveAppointmentSchedule(appointmentSchedule: AppointmentSchedule) {
    return this.http.post<AppointmentSchedule>(`${environment.baseUrl}/appointment-schedules`, appointmentSchedule);
  }

  deleteAppointmentSchedule(appointmentScheduleId: number) {
    return this.http.delete<void>(`${environment.baseUrl}/appointment-schedules/${appointmentScheduleId}`);
  }

  getAllAppointment() {
    return this.http.get<AppointmentSchedule[]>(`${environment.baseUrl}/appointment-schedules/appointment`);
  }


  getAllAppointmentScheduleByUserId(userId: number) {
    return this.http.get<AppointmentSchedule[]>(`${environment.baseUrl}/appointment-schedules/${userId}/user`);
  }


  getAllAppointmentScheduleByUserIdWhenDateHasNotPassed(userId: number) {
    return this.http.get<AppointmentSchedule[]>(`${environment.baseUrl}/appointment-schedules/${userId}/when-date-has-not-passed`);
  }


  getAllByUserIdAndAppointmentDateAndStatusIsNull(userId: number, date: string) {
    return this.http.get<AppointmentSchedule[]>(`${environment.baseUrl}/appointment-schedules/appointment-is-null/${userId}?date=${date}`);
  }
}
