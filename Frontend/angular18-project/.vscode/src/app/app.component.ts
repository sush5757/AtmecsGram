import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { CustomButtonComponent } from './custom-button/custom-button.component';
import { SuggestionsComponent } from './suggestions/suggestions.component';
import { User } from './types';
import { HttpClient } from '@angular/common/http';
import { UserService } from './user.service';
import { UserTileComponent } from './user-tile/user-tile.component';
import { PostsService } from './posts.service';
import { PostComponent } from './post/post.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; 

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
    this.user = this.userService.user;
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
