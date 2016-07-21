package org.openfact.representations;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.openfact.common.Version;

public class VersionRepresentation {
    public static final VersionRepresentation SINGLETON;

    private final String version = Version.VERSION;
    private final String buildTime = Version.BUILD_TIME;

    static {
         SINGLETON = new VersionRepresentation();
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("build-time")
    public String getBuildTime() {
        return buildTime;
    }
}
