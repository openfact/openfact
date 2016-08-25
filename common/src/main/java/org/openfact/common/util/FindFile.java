package org.openfact.common.util;

import org.openfact.common.constants.GenericConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FindFile {
    public static InputStream findFile(String openfactConfigFile) {
        if (openfactConfigFile.startsWith(GenericConstants.PROTOCOL_CLASSPATH)) {
            String classPathLocation = openfactConfigFile.replace(GenericConstants.PROTOCOL_CLASSPATH, "");
            // Try current class classloader first
            InputStream is = FindFile.class.getClassLoader().getResourceAsStream(classPathLocation);
            if (is == null) {
                is = Thread.currentThread().getContextClassLoader().getResourceAsStream(classPathLocation);
            }

            if (is != null) {
                return is;
            } else {
                throw new RuntimeException("Unable to find config from classpath: " + openfactConfigFile);
            }
        } else {
            // Fallback to file
            try {
                return new FileInputStream(openfactConfigFile);
            } catch (FileNotFoundException fnfe) {
                throw new RuntimeException(fnfe);
            }
        }
    }
}
