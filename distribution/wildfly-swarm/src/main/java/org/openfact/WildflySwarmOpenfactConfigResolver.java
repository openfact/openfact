package org.openfact;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

public class WildflySwarmOpenfactConfigResolver implements OpenfactConfigResolver {

    private static final JsonNode externalConfigNote = load();

    static JsonNode load() {
        String configPath = null;
        try {
            configPath = System.getProperty("openfact.config.path");
            if (configPath != null) {
                URL resource = Paths.get(configPath).toUri().toURL();
                return new ObjectMapper().readTree(resource);
            }
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Invalid configuration: " + configPath);
        } catch (IOException e) {
            throw new IllegalStateException("Could not read openfact-server.json file:" + configPath, e);
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
