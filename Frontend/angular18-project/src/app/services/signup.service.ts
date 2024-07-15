import { Injectable } from '@angular/core';
import { environment } from '../environment';
import { HttpClient } from '@angular/common/http';
import { User } from '../types';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  private baseUrl = environment.apiUrl;
  constructor(private http: HttpClient) {}

  signup(user: User) {
    return this.http.post<any>(`${this.baseUrl}/signup`, user);
  }
}
