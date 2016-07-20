package org.openfact.migration;

public interface MigrationModel {
    /**
     * Must have the form of major.minor.micro as the version is parsed and numbers are compared
     */
    String LATEST_VERSION = "1.9.2";

    String getStoredVersion();

    void setStoredVersion(String version);
}
