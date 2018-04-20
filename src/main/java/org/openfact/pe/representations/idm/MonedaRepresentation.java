package org.openfact.pe.representations.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class MonedaRepresentation {

    @NotNull
    @Pattern(regexp = "[a-zA-Z]{3}")
    private String codigo;

    @Digits(integer = 10, fraction = 4)
    private BigDecimal tipoCambio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
