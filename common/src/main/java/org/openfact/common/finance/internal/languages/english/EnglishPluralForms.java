package org.openfact.common.finance.internal.languages.english;

import org.openfact.common.finance.internal.languages.GenderType;
import org.openfact.common.finance.internal.languages.PluralForms;

public class EnglishPluralForms implements PluralForms {

    private final String form;

    public EnglishPluralForms(String form) {
        this.form = form;
    }

    @Override
    public String formFor(Integer value) {
        return form;
    }

    @Override
    public GenderType genderType() {
        return GenderType.NON_APPLICABLE;
    }
}
