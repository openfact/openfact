import { Directive, HostBinding, Input, OnInit } from '@angular/core';

import { FormControl } from '@angular/forms';

@Directive({
  selector: '[ofFormFieldValidationState]'
})
export class FormFieldValidationStateDirective implements OnInit {

  @Input()
  ofFormFieldValidationState: FormControl;

  @HostBinding('class.has-error')
  hasError: boolean;

  constructor() { }

  ngOnInit() {
    this.ofFormFieldValidationState.statusChanges.subscribe(controlValue => {
      if (this.ofFormFieldValidationState.valid || this.ofFormFieldValidationState.disabled) {
        this.hasError = false;
      } else {
        this.hasError = true;
      }
    });
  }

}
