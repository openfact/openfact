package org.openfact.common.finance.internal.languages.spanish;

import static org.openfact.common.finance.internal.support.BaseNumbersBuilder.baseNumbersBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openfact.common.finance.internal.BaseValues;
import org.openfact.common.finance.internal.languages.GenderForms;
import org.openfact.common.finance.internal.languages.PluralForms;

public class SpanishValues implements BaseValues {

    @Override
    public Map<Integer, GenderForms> baseNumbers() {
        return baseNumbersBuilder()
                .put(0, "")
                .put(1, GenderForms.genderForms("un", "una", "un", "un"))
                .put(2, "dos")
                .put(3, "tres")
                .put(4, "cuatro")
                .put(5, "cinco")
                .put(6, "seis")
                .put(7, "siete")
                .put(8, "ocho")
                .put(9, "nueve")
                .put(10, "diez")
                .put(11, "once")
                .put(12, "doce")
                .put(13, "trece")
                .put(14, "catorce")
                .put(15, "quince")
                .put(16, "dieciseis")
                .put(17, "diecisiete")
                .put(18, "dieciocho")
                .put(19, "diecinueve")
                .put(20, "veinte")
                .put(21, "veintiuno")
                .put(22, "veintidos")
                .put(23, "veintitres")
                .put(24, "veinticuatro")
                .put(25, "veinticinco")
                .put(26, "veintiseis")
                .put(27, "veintisiete")
                .put(28, "veintiocho")
                .put(29, "veintinueve")
                .put(30, "treinta")
                .put(40, "cuarenta")
                .put(50, "cincuenta")
                .put(60, "sesenta")
                .put(70, "setenta")
                .put(80, "ochenta")
                .put(90, "noventa")
                .put(100, "ciento")
                .put(200, "doscientos")
                .put(300, "trecientos")
                .put(400, "cuatrocientos")
                .put(500, "quinientos")
                .put(600, "seiscientos")
                .put(700, "setecientos")
                .put(800, "ochocientos")
                .put(900, "novecientos")                
                .build();
    }

    @Override
    public List<PluralForms> pluralForms() {
        return Arrays.<PluralForms>asList(
        		new SpanishPluralForms(""),
                new SpanishPluralForms("mil"),
                new SpanishPluralForms("millones"),
                new SpanishPluralForms("billones"));
    }

    @Override
    public String connector() {
        return "y";
    }

    @Override
    public String twoDigitsNumberSeparator() {
        return " y ";
    }
}
