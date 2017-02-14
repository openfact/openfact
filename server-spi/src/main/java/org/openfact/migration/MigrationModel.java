package org.openfact.migration;

public interface MigrationModel {
    String getStoredVersion();

    void setStoredVersion(String version);
}
