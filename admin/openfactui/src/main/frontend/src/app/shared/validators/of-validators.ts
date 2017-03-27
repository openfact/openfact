import { FormControl } from '@angular/forms';

export class OfValidators {

    static minValue(minValue: number): any {
        return (control: FormControl): { [key: string]: any } => {
            const v: number = control.value;
            return v < minValue ? { 'minValue': { 'requiredMinValue': minValue, 'actualValue': v } } : null;
        };
    }

    static maxValue(maxValue: number): any {
        return (control: FormControl): { [key: string]: any } => {
            const v: number = control.value;
            return v > maxValue ? { 'maxValue': { 'maxValuePermited': maxValue, 'actualValue': v } } : null;
        };
    }

}
