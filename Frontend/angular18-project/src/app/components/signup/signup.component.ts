  import { Router } from '@angular/router';
import { User } from '../../types';
import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SignupService } from '../../services/signup.service';
import { response } from 'express';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css',
})
export class SignupComponent {
  signupData: User = {
    email: '',
    first_name: '',
    last_name: '',
    password: '',
  };

  constructor(private router: Router, private signupService: SignupService) {}
  signupUser() {
    console.log('Signup data:', this.signupData);
    this.signupService.signup(this.signupData).subscribe(
      (response) => {
        console.log('Signup Succcessful!', response);
        this.router.navigate(['/login']);
      },
      (error) => {
        console.error('signup failed', error);
      }
    );
  }
  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}
