import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'of-read-file',
  templateUrl: './read-file.component.html',
  styles: [`
    input[type=file] {
      display: none;
    }
  `]
})
export class ReadFileComponent implements OnInit {

  @Input()
  showFileName = false;

  @Output()
  complete: EventEmitter<any> = new EventEmitter<any>();

  file: any = {
    fileName: undefined,
    data: undefined
  };

  constructor() { }

  ngOnInit() {
  }

  changeListener($event: any) {
    const inputValue = $event.target;
    const files: File = inputValue.files;

    const self = this;
    const reader: FileReader = new FileReader();

    this.file.fileName = files[0].name;
    reader.onloadend = function (e) {
      self.file.data = reader.result;
      self.complete.next(self.file);
    };
    reader.readAsText(files[0]);
  }

}
