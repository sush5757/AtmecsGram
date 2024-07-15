import { Injectable } from '@angular/core';
import { UserService } from './user.service';
import { Post } from '../types';

@Injectable({
  providedIn: 'root',
})
export class PostsService {
  constructor(public userService: UserService) {}
  posts: Post[] = [];
  // posts: Post[] = [
  //   {
  //     commentsCount: 0,
  //     description: '',
  //     id: '1',
  //     image:
  //       'https://img.freepik.com/free-photo/androgynous-avatar-non-binary-queer-person_23-2151100222.jpg?t=st=1718516938~exp=1718520538~hmac=30f14f1db34608431286c1e29d06635fcef459da7352fcce7776eb2ea901bfc1&w=740',
  //     likesCount: 0,
  //     sharesCount: 0,
  //     user: this.userService.user,
  //   },
  //   {
  //     commentsCount: 0,
  //     description: 'Hello World',
  //     id: '1',
  //     image:
  //       'https://img.freepik.com/free-photo/androgynous-avatar-non-binary-queer-person_23-2151100228.jpg?t=st=1718516052~exp=1718519652~hmac=455d21b73c3f80b07ecedb170f142e21e2eb49ef8ad18602aa0faf70883ae182&w=740',
  //     likesCount: 0,
  //     sharesCount: 0,
  //     user: this.userService.user,
  //   },
  //   {
  //     commentsCount: 0,
  //     description: 'Hello World',
  //     id: '1',

  //     image:
  //       'https://img.freepik.com/free-photo/digital-art-portrait-person-listening-music-headphones_23-2151065020.jpg?t=st=1718516200~exp=1718519800~hmac=6c81284aa034bea3b6a47bc8bca8f3beb74ca39599e943291ec651e91cbee610&w=740',
  //     likesCount: 0,
  //     sharesCount: 0,
  //     user: this.userService.user,
  //   },
  // ];

  addPost(post: Post) {
    // this.posts = [...this.posts, post];
    this.posts.push(post);
  }
  getPosts(): Post[] {
    return this.posts;
  }
}
