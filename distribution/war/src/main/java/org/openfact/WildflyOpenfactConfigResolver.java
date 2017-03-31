package org.openfact;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WildflyOpenfactConfigResolver implements OpenfactConfigResolver {

    private static final JsonNode externalConfigNote = load();

    static JsonNode load() {
        String configDir = null;
        try {
            configDir = System.getProperty("jboss.server.config.dir");
            if (configDir != null) {
                File f = new File(configDir + File.separator + "openfact-server.json");
                if (f.isFile()) {
                    return new ObjectMapper().readTree(f);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Invalid configuration: " + configDir);
        }
        return null;
    }

    @Override
    public JsonNode getNode() {
        JsonNode node = null;
        try {
            if (externalConfigNote != null) {
                return externalConfigNote;
            }

            URL resource = Thread.currentThread().getContextClassLoader().getResource("META-INF/openfact-server.json");
            if (resource != null) {
                node = new ObjectMapper().readTree(resource);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config", e);
        }
        return node;
    }

}
