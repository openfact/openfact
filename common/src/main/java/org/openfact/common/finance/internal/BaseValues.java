package org.openfact.common.finance.internal;

import org.openfact.common.finance.internal.languages.GenderForms;
import org.openfact.common.finance.internal.languages.PluralForms;

import java.util.List;
import java.util.Map;

public interface BaseValues {

    Map<Integer, GenderForms> baseNumbers();

    List<PluralForms> pluralForms();

    String connector();

    String twoDigitsNumberSeparator();
}
