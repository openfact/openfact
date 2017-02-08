package org.openfact.report.scriplet;

import net.sf.jasperreports.engine.JRDefaultScriptlet;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BasicOpenfactFormats extends JRDefaultScriptlet {

    public String stringFormat(String value) {
        return stringFormat(value, false);
    }

    public String stringFormat(String value, boolean toUppercase) {
        if (value == null) {
            return "";
        }
        return toUppercase ? value.toUpperCase() : value;
    }

    public String stringFormat(Collection<String> collection) {
        return stringFormat(collection, ",");
    }

    public String stringFormat(Collection<String> collection, String elementSeparator) {
        return stringFormat(collection, elementSeparator, false);
    }

    public String stringFormat(Collection<String> collection, String elementSeparator, boolean uppercase) {
        String result = String.join(elementSeparator, collection);
        return uppercase ? result.toUpperCase() : result;
    }

    public String numberFormat(Collection<Number> numbers, String elementSeparator, String currencySymbol, String groupingSeparator, String decimalSeparator, String numberDecimals) {
        return numbers.stream()
                .map(f -> numberFormat(f, currencySymbol, groupingSeparator, decimalSeparator, numberDecimals))
                .collect(Collectors.joining(elementSeparator));
    }

    public String numberFormat(Number number, String currencySymbol, String groupingSeparator, String decimalSeparator, String numberDecimals) {
        if (number == null) {
            number = 0;
        }

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

        DecimalFormat decimalFormat = (DecimalFormat) numberFormat;
        decimalFormat.setMinimumFractionDigits(Integer.parseInt(numberDecimals));
        decimalFormat.setMaximumFractionDigits(Integer.parseInt(numberDecimals));

        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) numberFormat).getDecimalFormatSymbols();
        decimalFormatSymbols.setGroupingSeparator(groupingSeparator.toCharArray()[0]);
        decimalFormatSymbols.setDecimalSeparator(decimalSeparator.toCharArray()[0]);
        decimalFormatSymbols.setCurrencySymbol(currencySymbol);

        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);

        return numberFormat.format(number);
    }

    public String sumElementsAndFormat(BigDecimal a, List<BigDecimal> b, String currencySymbol, String groupingSeparator, String decimalSeparator, String numberDecimals) {
        BigDecimal result = b.stream().reduce(BigDecimal.ZERO, BigDecimal::add).add(a);
        return numberFormat(result, currencySymbol, groupingSeparator, decimalSeparator, numberDecimals);
    }

}
