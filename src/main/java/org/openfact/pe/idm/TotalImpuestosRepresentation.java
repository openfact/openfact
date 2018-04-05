package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class TotalImpuestosRepresentation {

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Long IGV;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private Long ISC;

    public Long getIGV() {
        return IGV;
    }

    public void setIGV(Long IGV) {
        this.IGV = IGV;
    }

    public Long getISC() {
        return ISC;
    }

    public void setISC(Long ISC) {
        this.ISC = ISC;
    }

}
