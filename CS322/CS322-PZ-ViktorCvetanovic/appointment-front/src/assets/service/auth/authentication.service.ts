import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import jwt_decode from 'jwt-decode';
import {Router} from '@angular/router';
import {environment} from 'src/environments/environment';
import {SocialAuthService} from "angularx-social-login";

// export interface IUserToken {
//   username?: string;
//   roles?: string[];
// }


@Injectable({providedIn: 'root'})
export class AuthenticationService {
  private userToken: any;
  private token: any;

  httpHeaders = new HttpHeaders({
    'Content-Type': 'application/json',
    Authorization: 'Bearer xxx',
  });

  constructor(private http: HttpClient, private router: Router, private socialAuth: SocialAuthService) {
    try {
      this.token = sessionStorage.getItem('userToken');
      this.userToken = jwt_decode(this.token);
    } catch (e) {
      console.error(e);
      console.error('Not logged in.');
    }
  }


  login(username: string, password: string): void {
    this.http.post(`${environment.baseUrl}/login`, {username, password}, {
      responseType: 'text'
      , headers: this.httpHeaders
    }).subscribe(token => {
      console.log(token)
      if (token) {
        this.userToken = jwt_decode(token);
        this.token = token;
        sessionStorage.setItem('userToken', token);
        this.router.navigate(['home']);
      }
    });
  }

  register(data: any): void {
    this.http.post(`${environment.baseUrl}/register`, data, {
      responseType: 'text'
      , headers: this.httpHeaders
    }).subscribe(reg=> {
      if (reg) {
        this.router.navigate(['login']);
      }
    });
  }

  logout(): void {
    this.userToken = undefined;
    this.token = '';
    sessionStorage.removeItem('userToken');
    this.router.navigate(['']);
  }

  logOut(): void {
    this.socialAuth.signOut().then(r => {
      console.log(r)
    });
  }

  get userRoles(): string[] {
    return this.userToken.roles;
  }

  get userJwtToken(): string {
    return this.token;
  }

  get decodedAccessToken(): any {
    try {
      return jwt_decode(this.token);
    } catch(Error) {
      return null;
    }
  }

  get isLoggedIn(): boolean {
    return !!this.userJwtToken;
  }

  isAdmin(): boolean {
    return this.userRoles.includes('ROLE_ADMIN');
  }

  isDeveloper(): boolean {
    return this.userRoles.includes('ROLE_DEVELOPER');
  }
}
