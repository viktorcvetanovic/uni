import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppointmentSchedule} from "../../@types/AppointmentSchedule";
import {environment} from "../../../environments/environment";
import {User} from "../../@types/User";
import {Appointment} from "../../@types/Appointment";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }


  getUserById(id: number){
    return this.http.get<Appointment>(`${environment.baseUrl}/users/${id}`);
  }

}
