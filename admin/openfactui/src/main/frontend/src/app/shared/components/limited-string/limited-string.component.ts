import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'of-limited-string',
  templateUrl: './limited-string.component.html',
  styles: [``]
})
export class LimitedStringComponent implements OnInit {

  @Input()
  value: string;

  @Input()
  maxlength: number;

  currentMaxlength: number;

  constructor() { }

  ngOnInit() {
    if (!this.value) { this.value = ''; }
    this.currentMaxlength = this.maxlength;
  }

  readMore() {
    this.currentMaxlength = this.value.length;
  }

}
