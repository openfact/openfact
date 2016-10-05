package org.openfact.common.finance.internal;

import org.openfact.common.finance.internal.languages.GenderType;

public interface GenderAwareIntegerToStringConverter {
    String asWords(Integer value, GenderType genderType);
}
