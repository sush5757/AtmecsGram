import { Injectable } from '@angular/core';
import { User } from './types';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  user: User;
  following: User[] = [];

  constructor() {
    this.user = {
      avatar:
        'https://images.pexels.com/photos/58997/pexels-photo-58997.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1',
      first_name: 'Sushant',
      last_name: 'Manjare',
      email: '',
      bio: 'Full Stack developer',
      followers: 0,
      following: 0,
      posts: 12,
    };
  }

  increaseFollowing(followedUser: User) {
    this.user.following! += 1;

    this.following.push(followedUser);
    console.log(this.following);
  }
  decreaseFollowing(followedUser: User) {
    this.user.following! -= 1;
    this.following = this.following.filter((user) => user !== followedUser);
    console.log(this.following);
  }
}
