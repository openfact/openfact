package org.openfact.common.finance;

import org.openfact.common.finance.internal.Container;
import org.openfact.common.finance.internal.IntegerToStringConverter;

import static com.google.common.base.Verify.verifyNotNull;

public enum ValueConverters {

    GERMAN_INTEGER(Container.germanContainer().getNumbersConverter()),
    POLISH_INTEGER(Container.polishContainer().getNumbersConverter()),
    RUSSIAN_INTEGER(Container.russianContainer().getNumbersConverter()),
    CZECH_INTEGER(Container.czechContainer().getNumbersConverter()),
    ENGLISH_INTEGER(Container.englishContainer().getNumbersConverter()),
    SPANISH_INTEGER(Container.spanishContainer().getNumbersConverter());

    private IntegerToStringConverter converter;

    ValueConverters(IntegerToStringConverter converter) {
        this.converter = converter;
    }

    public String asWords(Integer value) {
        verifyNotNull(value);

        return converter.asWords(value);
    }
}
