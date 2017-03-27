import { InputManager } from './input.manager';

const minus = '-';
const number = 'number';
const emptyString = '';
const digitRegExp = /\d/;
const nonDigitsRegExp = /\D+/g;

export class InputService {

    private inputManager: InputManager;

    constructor(private htmlInputElement: any, private options: any) {
        this.inputManager = new InputManager(htmlInputElement, this.options);
    }

    addNumber(keyCode: number): void {
        const keyChar = String.fromCharCode(keyCode);
        const selectionStart = this.inputSelection.selectionStart;
        const selectionEnd = this.inputSelection.selectionEnd;
        this.rawValue = this.rawValue.substring(0, selectionStart) + keyChar + this.rawValue.substring(selectionEnd, this.rawValue.length);
        this.updateFieldValue(selectionStart + 1);
    }

    applyMask(isNumber: boolean, rawValue: string): string {
        const {allowNegative, decimalLimit, thousandsSeparatorSymbol, includeThousandsSeparator, decimalSymbol} = this.options;

        // New Start
        const prefixLength = this.options.prefix.length;
        const rawValueLength = rawValue.length;

        // If empty string
        if (rawValue === emptyString || (rawValue[0] === this.options.prefix[0] && rawValueLength === 1)) {
            return this.options.prefix.concat(emptyString).concat(this.options.suffix);
        }

        const indexOfLastDecimal = rawValue.lastIndexOf(decimalSymbol);
        const hasDecimal = indexOfLastDecimal !== -1;
        const isNegative = (rawValue[0] === minus) && allowNegative;

        let integer;
        let fraction;
        let mask; // result

        if (hasDecimal && (this.options.allowDecimal || this.options.requireDecimal)) {
            integer = rawValue.slice(0, indexOfLastDecimal);

            fraction = rawValue.slice(indexOfLastDecimal + 1, rawValueLength);
            fraction = fraction.replace(nonDigitsRegExp, emptyString);
        } else {
            integer = rawValue;
        }

        integer = integer.replace(nonDigitsRegExp, emptyString);
        integer = (includeThousandsSeparator) ? this.addThousandsSeparator(integer, thousandsSeparatorSymbol) : integer;
        mask = integer;

        if ((hasDecimal && this.options.allowDecimal) || this.options.requireDecimal === true) {
            if (rawValue[indexOfLastDecimal - 1] !== decimalSymbol) {
                mask = mask.concat(decimalSymbol);
            }

            if (fraction) {
                if (typeof decimalLimit === number) {
                    fraction = fraction.slice(0, decimalLimit);
                }
                mask = mask.concat(fraction);
            }

            if (this.options.requireDecimal === true && rawValue[indexOfLastDecimal - 1] === decimalSymbol) {
                mask.push(digitRegExp);
            }
        }

        // If prefix exists, then add it to mask
        if (prefixLength > 0) {
            mask = this.options.prefix.concat(mask);
        }

        if (isNegative) {
            mask = minus.concat(mask);
        }

        if (this.options.suffix.length > 0) {
            mask = mask.concat(this.options.suffix);
        }

        return mask;
    }

    convertToMask(strNumber) {
        return strNumber
            .split(emptyString)
            .map((char) => digitRegExp.test(char) ? digitRegExp : char);
    }

    addThousandsSeparator(n, thousandsSeparatorSymbol) {
        return n.replace(/\B(?=(\d{3})+(?!\d))/g, thousandsSeparatorSymbol);
    }

    clearMask(rawValue: string): number {
        let value = (rawValue || '0').replace(this.options.prefix, '').replace(this.options.suffix, '');

        if (this.options.thousandsSeparatorSymbol) {
            value = value.replace(new RegExp('\\' + this.options.thousandsSeparatorSymbol, 'g'), '');
        }

        if (this.options.decimalSymbol) {
            value = value.replace(this.options.decimalSymbol, '.');
        }

        return parseFloat(value);
    }

    changeToNegative(): void {
        if (this.options.allowNegative && this.rawValue !== '' && this.rawValue.charAt(0) !== '-' && this.value !== 0) {
            this.rawValue = '-' + this.rawValue;
        }
    }

    changeToPositive(): void {
        this.rawValue = this.rawValue.replace('-', '');
    }

    removeNumber(keyCode: number): void {
        let selectionStart = this.inputSelection.selectionStart;
        let selectionEnd = this.inputSelection.selectionEnd;

        if (selectionStart === selectionEnd) {
            if (keyCode === 8) {
                const lastNumber = this.rawValue.split('').reverse().join('').search(/\d/);
                selectionStart = this.rawValue.length - lastNumber - 1;
                selectionEnd = selectionStart + 1;
            } else {
                selectionEnd += 1;
            }
        }

        this.rawValue = this.rawValue.substring(0, selectionStart) + this.rawValue.substring(selectionEnd, this.rawValue.length);
        this.updateFieldValue(selectionStart);
    }

    resetSelection(): void {
        if (this.htmlInputElement.setSelectionRange) {
            this.htmlInputElement.setSelectionRange(this.rawValue.length, this.rawValue.length);
        }
    }

    updateFieldValue(selectionStart?: number): void {
        const newRawValue = this.applyMask(false, this.rawValue || '');
        selectionStart = selectionStart === undefined ? this.rawValue.length : selectionStart;
        this.inputManager.updateValueAndCursor(newRawValue, this.rawValue.length, selectionStart);
    }

    get canInputMoreNumbers(): boolean {
        return this.inputManager.canInputMoreNumbers;
    }

    get inputSelection(): any {
        return this.inputManager.inputSelection;
    }

    get rawValue(): string {
        return this.inputManager.rawValue;
    }

    set rawValue(value: string) {
        this.inputManager.rawValue = value;
    }

    get storedRawValue(): string {
        return this.inputManager.storedRawValue;
    }

    get value(): number {
        return this.clearMask(this.rawValue);
    }

    set value(value: number) {
        this.rawValue = this.applyMask(true, '' + value);
    }
}
