import { Component, EventEmitter, Input, Output } from '@angular/core';


@Component({
  selector: 'app-custom-button',
  standalone: true,
  imports: [],
  templateUrl: './custom-button.component.html',
  styleUrl: './custom-button.component.css'
})
export class CustomButtonComponent {

  @Input() btnText: string = 'Custom Button';
  @Input() isOutline: boolean = false;
  @Input() textSize: string = 'text-base';
  @Input() bgColor: string = 'bg-neutral-900';
  @Input() radius: string = 'rounded';
  @Output() onButtonTap = new EventEmitter<string>();

  getBtnClass() {
    return `${
      this.isOutline
        ? 'border border-neutral-900 hover:bg-neutral-200'
        : `${this.bgColor} text-white  hover:bg-neutral-800`
    }  ${this.textSize} px-2.5 py-1 ${this.radius}`;
  }

  onButtonClick() {
    this.onButtonTap.emit(this.btnText);
  }
}
