package org.openfact;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WildflySwarmOpenfactConfigResolver implements OpenfactConfigResolver {

    private static final JsonNode externalConfigNote = load();

    static JsonNode load() {
        String configPath = null;
        try {
            configPath = System.getProperty("openfact.config.path");
            if (configPath != null) {
                Path path = Paths.get(configPath);
                if (Files.exists(path)) {
                    URL resource = path.toUri().toURL();
                    return new ObjectMapper().readTree(resource);
                }
            }
        } catch (Exception e) {
            throw new IllegalStateException("Invalid configuration: " + configPath);
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
