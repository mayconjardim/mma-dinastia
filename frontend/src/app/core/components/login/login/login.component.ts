import { AuthService } from './../../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Creds } from 'src/app/core/models/creds';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  creds: Creds = {
    username: '',
    password: '',
  };

  username = new FormControl(null, Validators.minLength(3));
  password = new FormControl(null, Validators.minLength(3));

  constructor(private toast: ToastrService, private authService: AuthService) {}

  ngOnInit() {}

  login() {
    this.authService.authenticate(this.creds).subscribe((res) => {
      console.log(res);
    });
  }

  validForm() {
    return this.username.valid && this.password.valid;
  }
}
