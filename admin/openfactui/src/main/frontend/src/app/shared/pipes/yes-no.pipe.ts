import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'yesNo'
})
export class YesNoPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    const dictionary = args.split('.');
    return value ? dictionary[0] : dictionary[1];
  }

}
