package org.openfact.pe.models;

import java.math.BigDecimal;

public interface ImpuestosModel {

    BigDecimal getIgv();
    void setIgv(BigDecimal igv);

    BigDecimal getIsc();
    void setIsc(BigDecimal isc);

}
