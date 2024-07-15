import { response } from 'express';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication.service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  loginData = {
    email: '',
    password: '',
  };
  errorMessage: string = '';

  constructor(
    public router: Router,
    private authService: AuthenticationService,
    private userService: UserService
  ) {}

  loginUser() {
    const { email, password } = this.loginData;
    this.authService.login(email, password).subscribe(
      (response) => {
        console.log(response);
        this.userService.setUser(response);
        this.router.navigate(['/home']);
      },
      (error) => {
        this.errorMessage = error;
      }
    );
  }

  navigateToSignUp(): void {
    this.router.navigate(['/signup']);
  }
}
