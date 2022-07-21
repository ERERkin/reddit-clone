import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SignupRequestPayload} from "./singup-request.payload";
import {AuthService} from "../shared/auth.service";

@Component({
  selector: 'app-singup',
  templateUrl: './singup.component.html',
  styleUrls: ['./singup.component.css']
})
export class SingupComponent implements OnInit {
  signupRequestPayload: SignupRequestPayload;
  signupForm: FormGroup;

  constructor(private authService: AuthService) {
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
        console.log(data)
      });
  }
}
