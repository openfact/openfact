/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.common.finance.internal.converters;

import org.openfact.common.finance.internal.BigDecimalToStringConverter;
import org.openfact.common.finance.internal.IntegerToStringConverter;

import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;

public class BigDecimalToBankingMoneyConverter implements BigDecimalToStringConverter {

    private static final String FORMAT = "%s %s %02d/100";
    private static final int MAXIMAL_DECIMAL_PLACES_COUNT = 2;

    private final IntegerToStringConverter converter;
    private final String connectorSymbol;

    public BigDecimalToBankingMoneyConverter(IntegerToStringConverter converter, String currencySymbol) {
        this.converter = converter;
        this.connectorSymbol = currencySymbol;
    }

    @Override
    public String asWords(BigDecimal value) {
        validate(value);

        Integer units = value.intValue();
        Integer subunits = value.remainder(BigDecimal.ONE).multiply(new BigDecimal(100)).intValue();

        return format(FORMAT, converter.asWords(units), connectorSymbol, subunits);
    }

    private void validate(BigDecimal value) {
        checkArgument(value.scale() <= MAXIMAL_DECIMAL_PLACES_COUNT,
                "can't transform more than %s decimal places for value %s", MAXIMAL_DECIMAL_PLACES_COUNT, value);

        checkArgument(valueLessThatIntMax(value),
                "can't transform numbers greater than Integer.MAX_VALUE for value %s", value);

        checkArgument(valueGreaterThanOrEqualToZero(value),
                "can't transform negative numbers for value %s", value);
    }

    private boolean valueLessThatIntMax(BigDecimal value) {
        return value.compareTo(new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE)) == -1;
    }

    private boolean valueGreaterThanOrEqualToZero(BigDecimal value) {
        return value.signum() >= 0;
    }
}
