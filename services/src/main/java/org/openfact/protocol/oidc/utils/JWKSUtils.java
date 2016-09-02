package org.openfact.protocol.oidc.utils;

import java.io.IOException;
import java.security.PublicKey;

import org.openfact.broker.provider.util.SimpleHttp;
import org.openfact.jose.jwk.JSONWebKeySet;
import org.openfact.jose.jwk.JWK;
import org.openfact.jose.jwk.JWKParser;
import org.openfact.util.JsonSerialization;

public class JWKSUtils {

    public static JSONWebKeySet sendJwksRequest(String jwksURI) throws IOException {
        String keySetString = SimpleHttp.doGet(jwksURI).asString();
        return JsonSerialization.readValue(keySetString, JSONWebKeySet.class);
    }


    public static PublicKey getKeyForUse(JSONWebKeySet keySet, JWK.Use requestedUse) {
        for (JWK jwk : keySet.getKeys()) {
            JWKParser parser = JWKParser.create(jwk);
            if (parser.getJwk().getPublicKeyUse().equals(requestedUse.asString()) && parser.isAlgorithmSupported(jwk.getKeyType())) {
                return parser.toPublicKey();
            }
        }

        return null;
    }
}
