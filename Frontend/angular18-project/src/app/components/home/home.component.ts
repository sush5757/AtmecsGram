import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { HttpClient } from '@angular/common/http';

import { User,Post } from '../../types';

import { PostComponent } from '../post/post.component';
import { SuggestionsComponent } from '../suggestions/suggestions.component';

import { CommonModule } from '@angular/common';
import { PostsService } from '../../services/posts.service';

import { CustomButtonComponent } from '../custom-button/custom-button.component';
import { CreatePostComponent } from '../create-post/create-post.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CustomButtonComponent,
    PostComponent,
    SuggestionsComponent,
    CommonModule,
    CreatePostComponent,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css',
})
export class HomeComponent implements OnInit {
  posts: Post[] = [];
  showCreatePost: boolean = false;
  user!: User;
  constructor(
    private http: HttpClient,
    public userService: UserService,
    public postsService: PostsService
  ) {}

  ngOnInit() {
    this.userService.user$.subscribe((user) => (this.user = user));
    this.postsService.posts$.subscribe((posts) => (this.posts = posts));
    this.postsService.loadPosts();
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
