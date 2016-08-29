package org.openfact.testsuite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailUtil {

    private static Pattern mailPattern = Pattern.compile("http[^\\s\"]*");

    public static String getLink(String body) {
        Matcher matcher = mailPattern.matcher(body);
        if (matcher.find()) {
            return matcher.group();
        }
        throw new AssertionError("No link found in " + body);
    }

}
