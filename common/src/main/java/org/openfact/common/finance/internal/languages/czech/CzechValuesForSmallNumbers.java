package org.openfact.common.finance.internal.languages.czech;

import org.openfact.common.finance.internal.BaseValues;
import org.openfact.common.finance.internal.languages.GenderForms;
import org.openfact.common.finance.internal.languages.GenderType;
import org.openfact.common.finance.internal.languages.PluralForms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CzechValuesForSmallNumbers implements BaseValues {

    private final CzechValues originalValues = new CzechValues();

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        Map<Integer, GenderForms> baseNumbers = originalValues.baseNumbers();
        baseNumbers.put(1, GenderForms.genderForm(baseNumbers.get(1).formFor(GenderType.FEMININE)));
        baseNumbers.put(2, GenderForms.genderForm(baseNumbers.get(2).formFor(GenderType.MASCULINE)));
        return baseNumbers;
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.<PluralForms>asList(new CzechPluralForms());
    }

    @Override
    public String connector() {
        return originalValues.connector();
    }

    @Override
    public String twoDigitsNumberSeparator() {
        return " ";
    }
}
