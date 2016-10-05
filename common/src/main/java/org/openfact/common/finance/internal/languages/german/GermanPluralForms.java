package org.openfact.common.finance.internal.languages.german;

import org.openfact.common.finance.internal.languages.GenderType;
import org.openfact.common.finance.internal.languages.PluralForms;

public class GermanPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;

    private final GenderType genderType;

    public GermanPluralForms(String singularForm, String pluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genderType = genderType;
    }

    @Override
    public String formFor(Integer value) {
        return (value == 1) ? singularForm : pluralForm;
    }

    @Override
    public GenderType genderType() {
        return genderType;
    }
}
