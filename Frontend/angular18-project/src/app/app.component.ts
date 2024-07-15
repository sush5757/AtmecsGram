import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { SuggestionsComponent } from './components/suggestions/suggestions.component';
import { User } from './types';
import { HttpClient } from '@angular/common/http';
import { UserService } from './services/user.service';
import { UserTileComponent } from './components/user-tile/user-tile.component';

import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PostsService } from './services/posts.service';
import { CustomButtonComponent } from './components/custom-button/custom-button.component';
import { CreatePostComponent } from './components/create-post/create-post.component';
import { PostComponent } from './components/post/post.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    CustomButtonComponent,
    SuggestionsComponent,
    UserTileComponent,
    PostComponent,
    CreatePostComponent,
    FormsModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {
  title = 'angular18-project';
  showCreatePost: boolean = false;

  user!: User;
  constructor(
    private http: HttpClient,
    public userService: UserService,
    public postService: PostsService
  ) {}

  ngOnInit() {
    this.userService.user$.subscribe((value) => {
      console.log(value);
    });
    // this.user = this.userService.user;
    if (localStorage.getItem('user')) {
      this.userService.setUserFromLocalStorage();
    }
  }
  onUnfollow(user: User) {
    this.userService.decreaseFollowing(user);
  }

  onSignUp(event: any) {
    console.log('Event from ', event);
  }
  onLogin(event: any) {
    console.log('Event from ', event);
  }
  toggleCreatePost() {
    this.showCreatePost = !this.showCreatePost;
  }
}
