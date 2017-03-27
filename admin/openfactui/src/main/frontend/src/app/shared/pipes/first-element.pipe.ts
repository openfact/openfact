import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'firstElement'
})
export class FirstElementPipe implements PipeTransform {

  transform(value: any[], args?: any): any {
    return value[0];
  }

}
