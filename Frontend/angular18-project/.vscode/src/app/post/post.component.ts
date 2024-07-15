import { Component, Input } from '@angular/core';
import { Post } from '../types';
import { UserTileComponent } from '../user-tile/user-tile.component';
import { CustomButtonComponent } from '../custom-button/custom-button.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-post',
  standalone: true,
  imports: [CommonModule, UserTileComponent, CustomButtonComponent],
  templateUrl: './post.component.html',
  styleUrl: './post.component.css',
})
export class PostComponent {
  @Input() post!: Post;
}
