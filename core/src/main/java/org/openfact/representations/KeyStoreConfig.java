package org.openfact.representations;

/**
 * Configuration of KeyStore.
 */
public class KeyStoreConfig {

    protected Boolean organizationCertificate;
    protected String storePassword;
    protected String keyPassword;
    protected String keyAlias;
    protected String organizationAlias;
    protected String format;

    public Boolean isOrganizationCertificate() {
        return organizationCertificate;
    }

    public void setOrganizationCertificate(Boolean organizationCertificate) {
        this.organizationCertificate = organizationCertificate;
    }

    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

    public String getOrganizationAlias() {
        return organizationAlias;
    }

    public void setOrganizationAlias(String organizationAlias) {
        this.organizationAlias = organizationAlias;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
