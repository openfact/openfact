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
package org.openfact.common.finance.internal.languages.english;

import org.openfact.common.finance.internal.BaseValues;
import org.openfact.common.finance.internal.languages.GenderForms;
import org.openfact.common.finance.internal.languages.PluralForms;
import org.openfact.common.finance.internal.support.BaseNumbersBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EnglishValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return BaseNumbersBuilder.baseNumbersBuilder()
                .put(0, "zero")
                .put(1, "one")
                .put(2, "two")
                .put(3, "three")
                .put(4, "four")
                .put(5, "five")
                .put(6, "six")
                .put(7, "seven")
                .put(8, "eight")
                .put(9, "nine")
                .put(10, "ten")
                .put(11, "eleven")
                .put(12, "twelve")
                .put(13, "thirteen")
                .put(14, "fourteen")
                .put(15, "fifteen")
                .put(16, "sixteen")
                .put(17, "seventeen")
                .put(18, "eighteen")
                .put(19, "nineteen")
                .put(20, "twenty")
                .put(30, "thirty")
                .put(40, "forty")
                .put(50, "fifty")
                .put(60, "sixty")
                .put(70, "seventy")
                .put(80, "eighty")
                .put(90, "ninety")
                .put(100, "one hundred")
                .put(200, "two hundred")
                .put(300, "three hundred")
                .put(400, "four hundred")
                .put(500, "five hundred")
                .put(600, "six hundred")
                .put(700, "seven hundred")
                .put(800, "eight hundred")
                .put(900, "nine hundred")
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.<PluralForms>asList(
                new EnglishPluralForms(""),
                new EnglishPluralForms("thousand"),
                new EnglishPluralForms("million"),
                new EnglishPluralForms("billion"));
    }

    @Override
    public String connector() {
        return "and";
    }

    @Override
    public String twoDigitsNumberSeparator() {
        return "-";
    }
}
