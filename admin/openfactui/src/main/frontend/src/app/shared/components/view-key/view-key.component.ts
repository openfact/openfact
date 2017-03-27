import { Component, Input, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'of-view-key',
  templateUrl: './view-key.component.html',
  styles: [``]
})
export class ViewKeyComponent implements OnInit {

  @ViewChild('viewKeyModalContent')
  content: any;

  @Input()
  key: any;

  @Input()
  label: string;

  @Input()
  isSpan: boolean;

  @Input()
  isButton: boolean;

  @Input()
  isLink: boolean;

  constructor() { }

  ngOnInit() {
  }

}
