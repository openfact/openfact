package org.openfact.representations.idm;

/**
 * PEM values of key and certificate
 */
public class CertificateRepresentation {

    protected String privateKey;
    protected String certificate;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }


}
