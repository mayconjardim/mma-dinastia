import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { API_CONFIG } from '../config/api.config';
import { Creds } from '../models/creds';
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  jwtService: JwtHelperService = new JwtHelperService();

  constructor(private http: HttpClient) {}

  private httpOptions = {
    headers: new HttpHeaders({
      Authorization: `Basic ${window.btoa(
        `${API_CONFIG.username}:${API_CONFIG.password}`
      )}`,
    }),
  };

  authenticate(creds: Creds) {
    const body = new HttpParams()
      .set('username', creds.username)
      .set('password', creds.password)
      .set('grant_type', 'password');

    return this.http.post(
      `${API_CONFIG.baseUrl}/oauth/token`,
      body,
      this.httpOptions
    );
  }

  isAuthenticated() {
    let token = localStorage.getItem('token');
    if (token != null) {
      return !this.jwtService.isTokenExpired(token);
    }
    return false;
  }

  successfulLogin(access_token: string, User: string, UserId: string) {
    localStorage.setItem('token', access_token);
    localStorage.setItem('userName', User);
    localStorage.setItem('userId', UserId);
  }

  logout() {
    localStorage.clear();
  }
}
