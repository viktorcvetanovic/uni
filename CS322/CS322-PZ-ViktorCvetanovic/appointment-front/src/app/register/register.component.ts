import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FormControl, FormGroup, FormGroupDirective, NgForm, Validators} from "@angular/forms";
import {FacebookLoginProvider, GoogleLoginProvider, SocialAuthService} from "angularx-social-login";
import {AuthenticationService} from "../../assets/service/auth/authentication.service";
import {MatButton} from "@angular/material/button";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {



  form = new FormGroup({
    firstName: new FormControl('', Validators.required),
    lastName: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  constructor(private authService: AuthenticationService,
              private socialAuth: SocialAuthService) {
  }

  ngOnInit(): void {
  }

  isErrorState(control: FormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const isSubmitted = form && form.submitted;
    return !!(control && control.invalid && (control.dirty || control.touched || isSubmitted));
  }

  register(): void {
    this.authService.register(this.form.value);
  }

  registerWithSocial(socialPlatform: string) {
    let socialPlatformProvider: any;
    if (socialPlatform == "facebook") {
      socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
    } else if (socialPlatform == "google") {
      socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
    }

    this.socialAuth.signIn(socialPlatformProvider).then(data => {
      this.form.get("firstName")?.setValue(data.firstName);
      this.form.get("lastName")?.setValue(data.lastName);
      this.form.get("email")?.setValue(data.email);
      this.form.get("username")?.setValue(data.email.split("@")[0]);
      this.form.get("password")?.setValue(data.email.split("@")[0]);
      this.register();
    }, err => {
    });
  }

}
