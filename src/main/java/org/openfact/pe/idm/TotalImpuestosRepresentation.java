package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class TotalImpuestosRepresentation {

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal igv;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal isc;

    public BigDecimal getIgv() {
        return igv;
    }

    public void setIgv(BigDecimal igv) {
        this.igv = igv;
    }

    public BigDecimal getIsc() {
        return isc;
    }

    public void setIsc(BigDecimal isc) {
        this.isc = isc;
    }

}
