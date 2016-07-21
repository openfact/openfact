package org.openfact.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BrowserSecurityHeaders {
    public static final Map<String, String> headerAttributeMap;
    public static final Map<String, String> defaultHeaders;

    static {
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("xFrameOptions", "X-Frame-Options");
        headerMap.put("contentSecurityPolicy", "Content-Security-Policy");
        headerMap.put("xContentTypeOptions", "X-Content-Type-Options");

        Map<String, String> dh = new HashMap<>();
        dh.put("xFrameOptions", "SAMEORIGIN");
        dh.put("contentSecurityPolicy", "frame-src 'self'");
        dh.put("xContentTypeOptions", "nosniff");

        defaultHeaders = Collections.unmodifiableMap(dh);
        headerAttributeMap = Collections.unmodifiableMap(headerMap);
    }
}
