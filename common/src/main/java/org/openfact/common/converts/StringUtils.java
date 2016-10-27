package org.openfact.common.converts;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 01/08/2016.
 */
public class StringUtils {

    /**
     * Left padding a string with the given character
     *
     * @param str
     *            The string to be padded
     * @param length
     *            The total fix length of the string
     * @param padChar
     *            The pad character
     * @return The padded string
     */
    public static String padLeft(String str, int length, String padChar) {
        String pad = "";
        for (int i = 0; i < length; i++) {
            pad += padChar;
        }
        return pad.substring(str.length()) + str;
    }

    public static String leftPad(String originalString, int length, char padCharacter) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + originalString.length() < length) {
            sb.append(padCharacter);
        }
        sb.append(originalString);
        String paddedString = sb.toString();

        return paddedString;
    }

}
