package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 22/07/2016.
 */
public enum FileLocation {
    UrlKey("D:\\Factura\\Llave\\"),
    XmlInvoice("D:\\Factura\\Generate\\"),
    XmlValidator("D:\\Factura\\Invoice\\"),
    XmlSignature("D:\\Factura\\Signature\\"),
    KeyStore("D:\\Factura\\KeyStore\\"),
    XmlResponse("D:\\Factura\\Respuesta\\");


    private final String location;

    FileLocation(String value) {
        this.location = value;
    }

    public String getLocation() {
        return location;
    }
}
