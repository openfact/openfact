package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TotalImpuestosRepresentation {

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal IGV;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal ISC;

    public BigDecimal getIGV() {
        return IGV;
    }

    public void setIGV(BigDecimal IGV) {
        this.IGV = IGV;
    }

    public BigDecimal getISC() {
        return ISC;
    }

    public void setISC(BigDecimal ISC) {
        this.ISC = ISC;
    }

}
