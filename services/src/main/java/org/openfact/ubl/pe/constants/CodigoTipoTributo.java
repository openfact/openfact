package org.openfact.ubl.pe.constants;

public enum CodigoTipoTributo {

    IGV("1000", "VAT"),
    ISC("2000", "EXC"),
    OTROS("9999", "OTH");
    private final String id;
    private final String codigo;

    public String getCodigo() {
        return codigo;
    }

    public String getId() {
        return id;
    }

    private CodigoTipoTributo(String id, String codigo) {
        this.id = id;
        this.codigo = codigo;
    }
}
