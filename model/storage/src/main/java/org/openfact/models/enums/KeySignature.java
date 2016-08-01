package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 27/07/2016.
 */
public enum KeySignature {
    UrlKey("D:\\Factura\\Llave\\"),
    XmlInvoice("D:\\Factura\\Generate\\"),
    XmlValidator("D:\\Factura\\Invoice\\"),
    XmlSignature("D:\\Factura\\Signature\\"),
    KeyStore("D:\\Factura\\KeyStore\\"),
    XmlResponse("D:\\Factura\\Respuesta\\");

    private final String keysign;

    private KeySignature(String value) {
        this.keysign = value;
    }

    public String getKeySign() {
        return this.keysign;
    }
}