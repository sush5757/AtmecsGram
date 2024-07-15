import { Component, EventEmitter, Input, Output } from '@angular/core';
import { User } from '../../types';

import { UserService } from '../../services/user.service';
import { CustomButtonComponent } from '../custom-button/custom-button.component';

@Component({
  selector: 'app-user-tile',
  standalone: true,
  imports: [CustomButtonComponent],
  templateUrl: './user-tile.component.html',
  styleUrl: './user-tile.component.css',
})
export class UserTileComponent {
  @Input() user: User = {
    first_name: 'Sample USer',
    email: 'sample@email',
    avatar: '',
  };
  @Input() showButtons!: boolean;

  @Output() follow = new EventEmitter<User>();

  isFollowing: boolean = false;
  constructor(private userService: UserService) {}
  onTap(user: User) {
    this.isFollowing = true;
    this.follow.emit(user);
  }
}
