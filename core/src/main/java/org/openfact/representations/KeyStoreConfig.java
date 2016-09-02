package org.openfact.representations;

public class KeyStoreConfig {

    protected Boolean realmCertificate;
    protected String storePassword;
    protected String keyPassword;
    protected String keyAlias;
    protected String realmAlias;
    protected String format;

    public Boolean isRealmCertificate() {
        return realmCertificate;
    }

    public void setRealmCertificate(Boolean realmCertificate) {
        this.realmCertificate = realmCertificate;
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

    public String getRealmAlias() {
        return realmAlias;
    }

    public void setRealmAlias(String realmAlias) {
        this.realmAlias = realmAlias;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
