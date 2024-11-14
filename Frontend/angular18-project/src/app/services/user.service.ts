import { Injectable } from '@angular/core';
import { User } from '../types';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private user = new BehaviorSubject<User | null>(null);
  user$ = this.user as Observable<User>;
  following: User[] = [];

  constructor() {}
  setUser(user: User) {
    localStorage.setItem('user', JSON.stringify(user));
    this.user.next(user);
  }

  setUserFromLocalStorage() {
    const userData = localStorage.getItem('user');
    if (userData) {
      this.user.next(JSON.parse(userData));
    } else {
      this.user.next(null);
    }
  }

  increaseFollowing(followedUser: User) {
    // this.user.following! += 1;

    this.following.push(followedUser);
    console.log(this.following);
  }
  decreaseFollowing(followedUser: User) {
    // this.user.following! -= 1;
    this.following = this.following.filter((user) => user !== followedUser);
    console.log(this.following);
  }
}
