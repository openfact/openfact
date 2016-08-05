package org.openfact.common;



/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public abstract class Utils {


    /**
     * Left padding a string with the given character
     *
     * @param str     The string to be padded
     * @param length  The total fix length of the string
     * @param padChar The pad character
     * @return The padded string
     */
    public static String padLeft(String str, int length, String padChar) {
        String pad = "";
        for (int i = 0; i < length; i++) {
            pad += padChar;
        }
        return pad.substring(str.length()) + str;
    }

    public static String joinFormat(String type, int series, int number) {
        String padSerie = padLeft(String.valueOf(series), 3, "0");

        return type + padSerie + "-" + number;
    }
}
