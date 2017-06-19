package org.openfact.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Profile {

    private enum ProfileValue {
        PRODUCT, PREVIEW, COMMUNITY
    }

    private static ProfileValue value = load();

    static ProfileValue load() {
        String profile = null;
        try {
            profile = System.getProperty("openfact.profile");
            if (profile == null) {
                String jbossServerConfigDir = System.getProperty("jboss.server.config.dir");
                if (jbossServerConfigDir != null) {
                    File file = new File(jbossServerConfigDir, "profile.properties");
                    if (file.isFile()) {
                        Properties props = new Properties();
                        props.load(new FileInputStream(file));
                        profile = props.getProperty("profile");
                    }
                }
            }
        } catch (Exception e) {
        }

        if (profile == null) {
            return ProfileValue.valueOf(Version.DEFAULT_PROFILE.toUpperCase());
        } else {
            return ProfileValue.valueOf(profile.toUpperCase());
        }
    }

    public static String getName() {
        return value.name().toLowerCase();
    }

    public static boolean isPreviewEnabled() {
        return value.ordinal() >= ProfileValue.PREVIEW.ordinal();
    }

}
