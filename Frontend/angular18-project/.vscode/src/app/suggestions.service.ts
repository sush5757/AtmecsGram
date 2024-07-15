import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User, UserResponse } from './types';

@Injectable({
  providedIn: 'root',
})
export class SuggestionsService {
  baseUrl = 'https://reqres.in/api/users';
  constructor(private http: HttpClient) {}
  getUsersByPage(page: number) {
    return this.http.get<UserResponse>(`${this.baseUrl}?page=${page}`);
  }
}
