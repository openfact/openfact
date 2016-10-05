package org.openfact.common.finance.internal;

import org.openfact.common.finance.internal.converters.HundredsToWordsConverter;
import org.openfact.common.finance.internal.converters.IntegerToWordsConverter;
import org.openfact.common.finance.internal.languages.czech.CzechIntegerToWordsConverter;
import org.openfact.common.finance.internal.languages.czech.CzechValues;
import org.openfact.common.finance.internal.languages.german.GermanIntegerToWordsConverter;
import org.openfact.common.finance.internal.languages.german.GermanThousandToWordsConverter;
import org.openfact.common.finance.internal.languages.polish.PolishValues;
import org.openfact.common.finance.internal.languages.russian.RussianValues;
import org.openfact.common.finance.internal.languages.spanish.SpanishValues;
import org.openfact.common.finance.internal.converters.BigDecimalToBankingMoneyConverter;
import org.openfact.common.finance.internal.languages.czech.CzechValuesForSmallNumbers;
import org.openfact.common.finance.internal.languages.english.EnglishValues;
import org.openfact.common.finance.internal.languages.german.GermanValues;

public class Container {

    public static Container polishContainer() {
        return new Container(new PolishValues());
    }

    public static Container russianContainer() {
        return new Container(new RussianValues());
    }

    public static Container czechContainer() {
        CzechValues czechValues = new CzechValues();
        Container containerForBigNumbers = new Container(czechValues);
        Container containerForSmallNumbers = new Container(new CzechValuesForSmallNumbers());

        IntegerToStringConverter integerConverter = new CzechIntegerToWordsConverter(
                containerForBigNumbers.getNumbersConverter(), containerForSmallNumbers.getNumbersConverter(),
                czechValues.exceptions()
        );
        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                czechValues.connector());

        return new Container(integerConverter, bigDecimalBankingMoneyValueConverter);
    }

    public static Container englishContainer() {
        return new Container(new EnglishValues());
    }

    public static Container germanContainer() {

        GermanValues values = new GermanValues();

        GenderAwareIntegerToStringConverter germanThousandToWordsConverter = new GermanThousandToWordsConverter(
                values.baseNumbers());

        IntegerToStringConverter converter = new GermanIntegerToWordsConverter(
                new IntegerToWordsConverter(germanThousandToWordsConverter, values.pluralForms()), values.exceptions(),
                germanThousandToWordsConverter);

        BigDecimalToStringConverter bigDecimalBankingMoneyValueConverter = new BigDecimalToBankingMoneyConverter(
                converter, values.currency());

        return new Container(converter, bigDecimalBankingMoneyValueConverter);
    }
    
    public static Container spanishContainer() {
        return new Container(new SpanishValues());
    }

    private final IntegerToStringConverter integerConverter;
    private final BigDecimalToStringConverter bigDecimalConverter;

    public Container(BaseValues baseValues) {
    	GenderAwareIntegerToStringConverter hundredsToStringConverter = new HundredsToWordsConverter(baseValues.baseNumbers(),
                baseValues.twoDigitsNumberSeparator());

        integerConverter = new IntegerToWordsConverter(
                hundredsToStringConverter,
                baseValues.pluralForms());
        bigDecimalConverter = new BigDecimalToBankingMoneyConverter(
                integerConverter,
                baseValues.connector());
    }

    public Container(IntegerToStringConverter integerConverter,
                     BigDecimalToStringConverter bigDecimalConverter) {
        this.integerConverter = integerConverter;
        this.bigDecimalConverter = bigDecimalConverter;
    }

    public IntegerToStringConverter getNumbersConverter() {
        return integerConverter;
    }

    public BigDecimalToStringConverter getBankingMoneyConverter() {
        return bigDecimalConverter;
    }
}
