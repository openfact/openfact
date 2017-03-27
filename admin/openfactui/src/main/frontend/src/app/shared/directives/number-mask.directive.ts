import { AfterViewInit, Directive, ElementRef, HostListener, Input, OnInit, forwardRef } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

import { InputHandler } from './input/input.handler';

export const NUMBERMASKDIRECTIVE_VALUE_ACCESSOR: any = {
  provide: NG_VALUE_ACCESSOR,
  useExisting: forwardRef(() => NumberMaskDirective),
  multi: true
};
@Directive({
  selector: '[ofNumberMask]',
  providers: [NUMBERMASKDIRECTIVE_VALUE_ACCESSOR]
})
export class NumberMaskDirective implements AfterViewInit, ControlValueAccessor, OnInit {

  @Input()
  ofNumberMask: any = {};

  inputHandler: InputHandler;

  optionsTemplate = {
    align: 'right',
    decimalLimit: 2,
    decimalSymbol: '.',
    allowNegative: false,
    prefix: '',
    suffix: '',
    thousandsSeparatorSymbol: ',',
    includeThousandsSeparator: true,
    allowDecimal: false,
    requireDecimal: false
  };

  constructor(private elementRef: ElementRef) {
  }

  ngAfterViewInit() {
    this.elementRef.nativeElement.style.textAlign = this.ofNumberMask.align;
  }

  ngOnInit() {
    this.inputHandler = new InputHandler(this.elementRef.nativeElement, Object.assign({}, this.optionsTemplate, this.ofNumberMask));
  }

  @HostListener('click', ['$event'])
  handleClick(event: any) {
    this.inputHandler.handleClick(event);
  }

  @HostListener('cut', ['$event'])
  handleCut(event: any) {
    if (!this.isChromeAndroid()) {
      this.inputHandler.handleCut(event);
    }
  }

  @HostListener('input', ['$event'])
  handleInput(event: any) {
    if (this.isChromeAndroid()) {
      this.inputHandler.handleInput(event);
    }
  }

  @HostListener('keydown', ['$event'])
  handleKeydown(event: any) {
    if (!this.isChromeAndroid()) {
      this.inputHandler.handleKeydown(event);
    }
  }

  @HostListener('keypress', ['$event'])
  handleKeypress(event: any) {
    this.inputHandler.handleKeypress(event);
  }

  @HostListener('paste', ['$event'])
  handlePaste(event: any) {
    if (!this.isChromeAndroid()) {
      this.inputHandler.handlePaste(event);
    }
  }

  isChromeAndroid(): boolean {
    return /chrome/i.test(navigator.userAgent) && /android/i.test(navigator.userAgent);
  }

  registerOnChange(callbackFunction: Function): void {
    this.inputHandler.setOnModelChange(callbackFunction);
  }

  registerOnTouched(callbackFunction: Function): void {
    this.inputHandler.setOnModelTouched(callbackFunction);
  }

  setDisabledState(value: boolean): void {
    this.elementRef.nativeElement.disabled = value;
  }

  writeValue(value: number): void {
    this.inputHandler.setValue(value);
  }

}
