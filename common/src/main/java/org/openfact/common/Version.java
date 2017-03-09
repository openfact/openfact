package org.openfact.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Version {
    public static final String UNKNOWN = "UNKNOWN";
    public static String NAME;
    public static String NAME_HTML;
    public static String VERSION;
    public static String RESOURCES_VERSION;
    public static String BUILD_TIME;
    public static String DEFAULT_PROFILE;

    static {
        Properties props = new Properties();
        InputStream is = Version.class.getResourceAsStream("/openfact-version.properties");
        try {
            props.load(is);
            Version.NAME = props.getProperty("name");
            Version.NAME_HTML = props.getProperty("name-html");
            Version.DEFAULT_PROFILE = props.getProperty("default-profile");
            Version.VERSION = props.getProperty("version");
            Version.BUILD_TIME = props.getProperty("build-time");
            Version.RESOURCES_VERSION = Version.VERSION.toLowerCase();
        } catch (IOException e) {
            Version.VERSION = Version.UNKNOWN;
            Version.BUILD_TIME = Version.UNKNOWN;
        }
    }

}
