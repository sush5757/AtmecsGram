import { Component, Input } from '@angular/core';
import { CustomButtonComponent } from '../custom-button/custom-button.component';
import { HttpClient } from '@angular/common/http';
import { User, UserResponse } from '../types';
import { UserTileComponent } from '../user-tile/user-tile.component';
import { SuggestionsService } from '../suggestions.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-suggestions',
  standalone: true,
  imports: [CustomButtonComponent, UserTileComponent],
  templateUrl: './suggestions.component.html',
  styleUrl: './suggestions.component.css',
})
export class SuggestionsComponent {
  @Input() maxUserLimit!: number;
  users: User[] = [];
  usersLimit!: number;
  pageNumber: number = 1;
  constructor(
    private suggestionService: SuggestionsService,
    private userService: UserService
  ) {}
  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this.suggestionService
      .getUsersByPage(this.pageNumber)
      .subscribe((value) => {
        // this.users = value.data;
        // value.data.forEach((user) => this.users.push(user));
        if (value.data) this.users = [...this.users, ...value.data];
      });
  }
  onSeeMore() {
    // this.usersLimit = this.users.length;
    this.pageNumber += 1;
    this.getUsers();
  }

  onSeeLess() {
    this.usersLimit = this.maxUserLimit;
  }

  onTap(user: User) {
    console.log('tapped', user);
  }
  onFollowClicked(user: User) {
    // console.log('now i am following ', user);
    this.userService.increaseFollowing(user);
  }
}
