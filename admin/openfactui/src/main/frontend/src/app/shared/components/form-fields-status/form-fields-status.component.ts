import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'of-form-fields-status',
  templateUrl: './form-fields-status.component.html',
  styles: [``]
})
export class FormFieldsStatusComponent implements OnInit {

  @Input()
  ofForm: FormGroup;

  hasRequiredFields: boolean;

  constructor() { }

  ngOnInit() {
    this.refreshState();
  }

  refreshState() {
    this.hasRequiredFields = this.checkIfHasRequiredFields(this.ofForm);
  }

  checkIfHasRequiredFields(formGroup: FormGroup): boolean {
    let result = false;
    for (const key in this.ofForm.controls) {
      if (!this.ofForm.controls[key]) { continue; }

      const abstractControl: AbstractControl = this.ofForm.controls[key];
      if (abstractControl instanceof FormGroup) {
        if (this.checkIfHasRequiredFields(abstractControl)) {
          result = true;
          break;
        }
      } else {
        const validator: any = abstractControl.validator && abstractControl.validator(new FormControl());
        if (validator && validator.required) {
          result = true;
          break;
        }
      }
    }
    return result;
  }

}
