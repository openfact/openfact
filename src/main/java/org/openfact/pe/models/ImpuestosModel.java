package org.openfact.pe.models;

import java.math.BigDecimal;

public interface ImpuestosModel {

    BigDecimal getIGV();
    void setIGV(BigDecimal IGV);

    BigDecimal getISC();
    void setISC(BigDecimal ISC);
}
