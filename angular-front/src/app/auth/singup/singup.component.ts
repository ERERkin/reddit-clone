import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SignupRequestPayload} from "./singup-request.payload";
import {AuthService} from "../shared/auth.service";
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.css']
})
export class SingupComponent implements OnInit {
  signupRequestPayload: SignupRequestPayload;
  signupForm: FormGroup;

  constructor(private authService: AuthService,
              private router: Router,
              private toastr: ToastrService) {
    this.authService = authService;
    this.signupRequestPayload = {
      username: '',
      email: '',
      password: ''
    }
    this.signupForm = new FormGroup({
      username: new FormControl('', Validators.required),
      email: new FormControl( '', [Validators.required, Validators.email]),
      password: new FormControl( '', Validators.required)
    });
  }

  ngOnInit(): void {
    this.signupForm = new FormGroup({
      username: new FormControl('', Validators.required),
      email: new FormControl( '', [Validators.required, Validators.email]),
      password: new FormControl( '', Validators.required)
    });
  }


  signup(){
    // @ts-ignore
    this.signupRequestPayload.email = this.signupForm.get('email').value;
    // @ts-ignore
    this.signupRequestPayload.username = this.signupForm.get('username').value;
    // @ts-ignore
    this.signupRequestPayload.password = this.signupForm.get('password').value;

    this.authService.signup(this.signupRequestPayload)
      .subscribe(data => {
        this.router.navigate(['/login'],
          { queryParams: { registered: 'true' } });
      }, error => {
        console.log(error);
        this.toastr.error('Registration Failed! Please try again');
      });
  }
}
