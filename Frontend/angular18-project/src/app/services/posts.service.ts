import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Post } from '../types';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
@Injectable({
  providedIn: 'root',
})
export class PostsService {
  private apiUrl = 'http://localhost:8080/posts';
  private postsSubject = new BehaviorSubject<Post[]>([]); // Store posts in a BehaviorSubject

  posts$ = this.postsSubject.asObservable(); // Expose as an Observable

  constructor(public userService: UserService, private http: HttpClient) {}

  loadPosts(): void {
    this.http.get<Post[]>(this.apiUrl).subscribe((posts) => {
      this.postsSubject.next(posts); // Update the posts
    });
  }
  createPost(post: Post): Observable<Post> {
    return this.http.post<Post>(this.apiUrl, post);
  }
}
