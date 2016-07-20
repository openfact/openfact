package org.openfact.common.util;

public class Base64Url {
    public static String encode(byte[] bytes) {
        String s = Base64.encodeBytes(bytes);
        s = s.split("=")[0]; // Remove any trailing '='s
        s = s.replace('+', '-'); // 62nd char of encoding
        s = s.replace('/', '_'); // 63rd char of encoding
        return s;
    }

    public static byte[] decode(String s) {
        s = s.replace('-', '+'); // 62nd char of encoding
        s = s.replace('_', '/'); // 63rd char of encoding
        switch (s.length() % 4) // Pad with trailing '='s
        {
            case 0:
                break; // No pad chars in this case
            case 2:
                s += "==";
                break; // Two pad chars
            case 3:
                s += "=";
                break; // One pad char
            default:
                throw new RuntimeException(
                        "Illegal base64url string!");
        }
        try {
            // KEYCLOAK-2479 : Avoid to try gzip decoding as for some objects, it may display exception to STDERR. And we know that object wasn't encoded as GZIP
            return Base64.decode(s, Base64.DONT_GUNZIP);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
