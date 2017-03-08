package org.openfact.theme;

import org.jboss.logging.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesUtil {

    private static final Logger logger = Logger.getLogger(PropertiesUtil.class);

    public static final Pattern DETECT_ENCODING_PATTERN = Pattern.compile("^#\\s*encoding:\\s*([\\w.:-]+)", Pattern.CASE_INSENSITIVE);

    public static final Charset DEFAULT_ENCODING = Charset.forName("ISO-8859-1");

    /**
     * <p>
     * Detect file encoding from the first line of the property file. If the first line in the file doesn't contain the
     * comment with the encoding, it uses ISO-8859-1 as default encoding for backwards compatibility.
     * </p>
     * <p>
     * The specified stream is closed before this method returns.
     * </p>
     * 
     * @param in The input stream
     * @return Encoding
     * @throws IOException
     */
    public static Charset detectEncoding(InputStream in) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, DEFAULT_ENCODING))) {
            String firstLine = br.readLine();
            if (firstLine != null) {
                Matcher matcher = DETECT_ENCODING_PATTERN.matcher(firstLine);
                if (matcher.find()) {
                    String encoding = matcher.group(1);
                    if (Charset.isSupported(encoding)) {
                        return Charset.forName(encoding);
                    } else {
                        logger.warnv("Unsupported encoding: {0}", encoding);
                    }
                }
            }
        }
        return DEFAULT_ENCODING;
    }
}
