package org.openfact.ubl.pe.constants;

public enum CodTipDocIdentidad {

    DOC_TRIB_NO_DOM_SIN_RUC("0"),
    DNI("1"),
    EXTRANJERIA("4"),
    RUC("6"),
    PASAPORTE("7"),
    DEC_DIPLOMATICA("A");
    private final String codigo;

    public String getCodigo() {
        return codigo;
    }

    private CodTipDocIdentidad(String codigo) {
        this.codigo = codigo;
    }
}
