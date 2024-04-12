import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";
import {Appointment} from "../../@types/Appointment";
import {AppointmentSchedule} from "../../@types/AppointmentSchedule";

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http: HttpClient) {
  }

  getAllAppointment() {
    return this.http.get<Appointment[]>(`${environment.baseUrl}/appointments`);
  }

  saveAppointment(appointment: Appointment) {
    return this.http.post<Appointment>(`${environment.baseUrl}/appointments`, appointment);
  }

  updateAppointment(appointment: Appointment) {
    return this.http.put<Appointment>(`${environment.baseUrl}/appointments`, appointment);
  }

  deleteAppointment(id: number) {
    return this.http.delete<void>(`${environment.baseUrl}/appointments/${id}`);
  }

  getAllAppointmentSchedule() {
    return this.http.get<Appointment[]>(`${environment.baseUrl}/appointments/appointment_schedule`);
  }

  getAppointmentById(id: number) {
    return this.http.get<Appointment>(`${environment.baseUrl}/appointments/${id}`);
  }

  getAllAppointmentByDate(date: string) {
    return this.http.get<Appointment[]>(`${environment.baseUrl}/appointments/date/?date=${date}`);
  }

}
