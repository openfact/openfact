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

import com.google.common.collect.Range;
import org.openfact.common.finance.internal.GenderAwareIntegerToStringConverter;
import org.openfact.common.finance.internal.languages.GenderForms;
import org.openfact.common.finance.internal.languages.GenderType;

import java.util.Map;

import static java.lang.String.format;

public class HundredsToWordsConverter implements GenderAwareIntegerToStringConverter {

    private final Map<Integer, GenderForms> baseValues;
    private String twoDigitsNumberSeparator;

    public HundredsToWordsConverter(Map<Integer, GenderForms> baseValues, String twoDigitsNumberSeparator) {
        this.baseValues = baseValues;
        this.twoDigitsNumberSeparator = twoDigitsNumberSeparator;
    }

    @Override
    public String asWords(Integer value, GenderType genderType) {
        if (baseValues.containsKey(value)) {
            return baseValues.get(value).formFor(genderType);
        } else if (Range.closed(21, 99).contains(value)) {
            return twoDigitsNumberAsString(value, genderType);
        } else if (Range.closed(101, 999).contains(value)) {
            return threeDigitsNumberAsString(value, genderType);
        }

        throw new IllegalArgumentException(format("Can't convert %d", value));
    }

    private String twoDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer units = value % 10;
        Integer tens = value - units;
        return format("%s%s%s", asWords(tens, genderType), twoDigitsNumberSeparator, asWords(units, genderType));
    }

    private String threeDigitsNumberAsString(Integer value, GenderType genderType) {
        Integer tensWithUnits = value % 100;
        Integer hundreds = value - tensWithUnits;
        return format("%s %s", asWords(hundreds, genderType), asWords(tensWithUnits, genderType));
    }
}
