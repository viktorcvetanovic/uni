import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {User} from "../../@types/User";

@Injectable({
  providedIn: 'root'
})
export class LoggedInUserService {


  private user: any | null = null;
constructor(private http: HttpClient) { }

  getLoggedInUser(username: string): Observable<User> {
    if (this.user) {
      return new Observable<any>(observer => {
        observer.next(this.user);
        observer.complete();
      });
    }
    return this.http.get<any>(`${environment.baseUrl}/logged-in-user/${username}`, {responseType: "json"});
  }
}
