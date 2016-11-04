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
package org.openfact.common.finance.internal.languages.german;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openfact.common.finance.internal.languages.GenderForms;
import org.openfact.common.finance.internal.languages.GenderType;
import org.openfact.common.finance.internal.languages.PluralForms;
import org.openfact.common.finance.internal.support.BaseNumbersBuilder;

import com.google.common.collect.ImmutableMap;

public class GermanValues {

    public Map<Integer, GenderForms> baseNumbers() {
        return BaseNumbersBuilder.baseNumbersBuilder()
                .put(0, "null")
                .put(1, GenderForms.genderForms("ein", "eine", "ein", "ein"))
                .put(2, "zwei")
                .put(3, "drei")
                .put(4, "vier")
                .put(5, "fünf")
                .put(6, "sechs")
                .put(7, "sieben")
                .put(8, "acht")
                .put(9, "neun")
                .put(10, "zehn")
                .put(11, "elf")
                .put(12, "zwölf")
                .put(13, "dreizehn")
                .put(14, "vierzehn")
                .put(15, "fünfzehn")
                .put(16, "sechzehn")
                .put(17, "siebzehn")
                .put(18, "achtzehn")
                .put(19, "neunzehn")
                .put(20, "zwanzig")
                .put(30, "dreißig")
                .put(40, "vierzig")
                .put(50, "fünfzig")
                .put(60, "sechzig")
                .put(70, "siebzig")
                .put(80, "achtzig")
                .put(90, "neunzig")
                .put(100, "einhundert")
                .put(200, "zweihundert")
                .put(300, "dreihundert")
                .put(400, "vierhundert")
                .put(500, "fünfhundert")
                .put(600, "sechshundert")
                .put(700, "siebenhundert")
                .put(800, "achthundert")
                .put(900, "neunhundert")
                .build();
    }

    public Map<Integer, String> exceptions() {
        return ImmutableMap.<Integer, String>builder().put(1, "eins").build();
    }

    public List<PluralForms> pluralForms() {
        return Arrays.<PluralForms>asList(
                new GermanPluralForms("Million", "Millionen", GenderType.FEMININE),
                new GermanPluralForms("Milliarde", "Milliarden", GenderType.FEMININE));
    }

    public String currency() {
        return "€";
    }
}
