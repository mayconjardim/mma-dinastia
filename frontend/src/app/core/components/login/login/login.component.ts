import { AuthService } from './../../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
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

  constructor(
    private toast: ToastrService,
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit() {}

  login() {
    const observer = {
      next: (res: any) => {
        this.handleSuccessfulLogin(res);
      },
      error: () => {
        this.handleFailedLogin();
      },
    };

    this.authService.authenticate(this.creds).subscribe(observer);
  }

  handleSuccessfulLogin(response: any) {
    this.authService.successfulLogin(
      response['access_token'],
      response['User'],
      response['UserId']
    );
    this.toast.success('Logado com sucesso!', 'Login');
    this.router.navigate(['']);
  }

  handleFailedLogin() {
    this.toast.error('Usuário e/ou senha inválidos!', 'Erro');
  }

  validForm() {
    return this.username.valid && this.password.valid;
  }
}
