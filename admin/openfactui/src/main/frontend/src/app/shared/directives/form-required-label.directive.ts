import { AbstractControl, FormControl, Validators } from '@angular/forms';
import { Directive, HostBinding, HostListener, Input, OnInit } from '@angular/core';

@Directive({
  selector: '[ofFormRequiredLabel]'
})
export class FormRequiredLabelDirective implements OnInit {

  @Input()
  ofFormRequiredLabel: FormControl;

  @HostBinding('class.required-pf')
  isRequired: boolean;

  constructor() { }

  ngOnInit() {
    const validator: any = this.ofFormRequiredLabel.validator && this.ofFormRequiredLabel.validator(new FormControl());
    this.isRequired = validator && validator.required;
  }

}
