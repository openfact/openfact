package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 20/07/2016.
 */
public enum CodigoTipoDocumento {
    FACTURA("01"),
    BOLETA("03"),
    NCREDITO("07"),
    NDEBITO("08"),
    GUIA_REMISION("09"),
    TICKET("12"),
    DOC_SBS("13"),
    DOC_AFP("18"),
    GUIA_TRANSPORTISTA("31"),
    SEAE("56");

    private final String codigo;

    CodigoTipoDocumento(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
