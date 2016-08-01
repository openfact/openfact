package org.openfact.models.enums;

/**
 * Created by Alex Pariona-"alexpariona@openfact.com" on 20/07/2016.
 */
public enum CodigoTipoPrecioVentaUnit {
    PRECIO_UNITARIO("01"),
    VALOR_REF_UNIT_EN_OPER_NO_ORENOSAS("02");

    private final String codigo;

    CodigoTipoPrecioVentaUnit(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
