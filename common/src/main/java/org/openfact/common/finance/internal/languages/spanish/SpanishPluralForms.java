package org.openfact.common.finance.internal.languages.spanish;

import org.openfact.common.finance.internal.languages.GenderType;
import org.openfact.common.finance.internal.languages.PluralForms;

public class SpanishPluralForms implements PluralForms {

	private final String form;

	public SpanishPluralForms(String form) {
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
