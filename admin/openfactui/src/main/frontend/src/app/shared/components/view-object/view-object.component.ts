import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'of-view-object',
  templateUrl: './view-object.component.html',
  styles: [`
    .viewer {
      padding: 20px 20px 10px 20px;
    }
  `]
})
export class ViewObjectComponent implements OnInit {

  @Input()
  object: any;

  @Input()
  label: string;

  constructor() { }

  ngOnInit() { }

}
