import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { FormGroup } from '@angular/forms';

@Component({
  selector: 'of-button-reset',
  templateUrl: './button-reset.component.html',
  styles: []
})
export class ButtonResetComponent implements OnInit {

  @Input()
  ofForm: FormGroup;

  @Output()
  ofOnReset: EventEmitter<boolean> = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit() {
  }

  reset() {
    this.ofForm.reset();
    this.ofOnReset.emit(true);
  }

}
