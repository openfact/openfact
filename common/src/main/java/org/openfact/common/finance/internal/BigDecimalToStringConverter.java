package org.openfact.common.finance.internal;

import java.math.BigDecimal;

public interface BigDecimalToStringConverter {
    String asWords(BigDecimal value);    
}
