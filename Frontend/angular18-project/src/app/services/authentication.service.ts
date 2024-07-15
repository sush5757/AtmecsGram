import { HttpClient } from '@angular/common/http';
import { Injectable, Inject } from '@angular/core';
import { BehaviorSubject, Observable, catchError, of, tap } from 'rxjs';
import { environment } from '../environment';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private baseUrl = environment.apiUrl; // Assuming your backend API base URL
  private loggedInSubject = new BehaviorSubject<boolean>(false);
  constructor(private http: HttpClient) {
    this.loggedInSubject.next(this.isLoggedIn());
  }

  login(email: string, password: string): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/login`, { email, password });
    // .pipe(
    //   tap((response) => {
    //     localStorage.setItem('token', response.token);
    //     this.loggedInSubject.next(true);
    //   })
    // );
  }
  logout(): void {
    localStorage.removeItem('token');
    this.loggedInSubject.next(false);
  }

  isLoggedIn() {
    return !!localStorage.getItem('token');
  }
  get isLoggedIn$(): Observable<boolean> {
    return this.loggedInSubject.asObservable(); // Observable for authentication status
  }
}
