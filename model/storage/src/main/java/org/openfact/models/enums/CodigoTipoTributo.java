package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 20/07/2016.
 */
public enum CodigoTipoTributo {
    IGV("1000", "VAT"),
    ISC("2000", "EXC"),
    OTROS("9999", "OTH");
    private final String id;
    private final String codigo;

    CodigoTipoTributo(String id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getId() {
        return id;
    }
}