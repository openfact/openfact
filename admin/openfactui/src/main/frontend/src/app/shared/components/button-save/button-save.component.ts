import { Component, Input, OnInit } from '@angular/core';

import { FormGroup } from '@angular/forms';

@Component({
  selector: 'of-button-save',
  templateUrl: './button-save.component.html',
  styles: []
})
export class ButtonSaveComponent implements OnInit {

  @Input()
  ofForm: FormGroup;

  @Input()
  working = false;

  constructor() { }

  ngOnInit() {
  }

  onClickChild(event) {
    if (!this.ofForm.valid) {
      event.preventDefault();
    }
  }

}
