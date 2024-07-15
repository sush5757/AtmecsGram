import { Component, NgModule } from '@angular/core';

import { Post } from '../../types';

import { FormsModule, NgModel, NgModelGroup } from '@angular/forms';
import { PostsService } from '../../services/posts.service';
import { CustomButtonComponent } from '../custom-button/custom-button.component';

@Component({
  selector: 'app-create-post',
  standalone: true,
  imports: [CustomButtonComponent, FormsModule],
  templateUrl: './create-post.component.html',
  styleUrl: './create-post.component.css',
})
export class CreatePostComponent {
  // description: string = '';
  // imageUrl: string = '';
  description!: string;
  imageUrl!: string;
  constructor(private postsService: PostsService) {}
  submitPost() {
    if (this.description || this.imageUrl) {
      const newPost: Post = {
        description: this.description,
        image: this.imageUrl,
        commentsCount: 0,
        likesCount: 0,
        id: new Date().toISOString(),
        sharesCount: 0,
        user: {
          first_name: 'John Doe',
          avatar:
            'https://images.pexels.com/photos/1458908/pexels-photo-1458908.jpeg?auto=compress&cs=tinysrgb&w=600&lazy=load',
          email: 'john.doe@example.com',
        },
      };

      this.postsService.addPost(newPost);
      this.description = '';
      this.imageUrl = '';
    } else {
      alert('Description or image URL are mandatory');
    }
  }
}
