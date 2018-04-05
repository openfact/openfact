package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MonedaRepresentation {

    @NotNull
    @Pattern(regexp = "[a-zA-Z]{3}")
    private String codigo;

    @Digits(integer = 10, fraction = 4)
    private Long tipoCambio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Long tipoCambio) {
        this.tipoCambio = tipoCambio;
    }
}
