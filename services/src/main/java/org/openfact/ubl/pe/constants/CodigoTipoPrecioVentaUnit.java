package org.openfact.ubl.pe.constants;

public enum CodigoTipoPrecioVentaUnit {
    PRECIO_UNITARIO("01"),
    VALOR_REF_UNIT_EN_OPER_NO_ORENOSAS("02");
    
    private final String codigo;

    public String getCodigo() {
        return codigo;
    }   

    private CodigoTipoPrecioVentaUnit(String codigo) {        
        this.codigo = codigo;
    }
}
