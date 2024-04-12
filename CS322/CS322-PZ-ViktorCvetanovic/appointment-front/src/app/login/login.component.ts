import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {FacebookLoginProvider, GoogleLoginProvider, SocialAuthService} from "angularx-social-login";
import {AuthenticationService} from "../../assets/service/auth/authentication.service";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @ViewChild("loginBtn") btn!: ElementRef;

  form = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  });

  constructor(private authService: AuthenticationService, private socialAuth: SocialAuthService) {
  }

  ngOnInit(): void {
  }

  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }

  login(): void {
    this.authService.login(this.form.value.username.trim(), this.form.value.password);
  }

  loginWithSocial(socialPlatform: string) {
    let socialPlatformProvider: any;
    if (socialPlatform == "facebook") {
      socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
    } else if (socialPlatform == "google") {
      socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
    }

      this.socialAuth.signIn(socialPlatformProvider).then(data => {
        this.form.get("username")?.setValue(data.email.split("@")[0]);
        this.form.get("password")?.setValue(data.email.split("@")[0]);
        this.login();
      });

  }
}
