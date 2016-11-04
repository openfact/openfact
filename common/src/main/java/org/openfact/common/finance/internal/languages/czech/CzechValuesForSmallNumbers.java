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
