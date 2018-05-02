package org.openfact.pe.models;

import java.math.BigDecimal;

public interface TotalInformacionAdicionalModel {

    BigDecimal getTotalGravado();
    void setTotalGravado(BigDecimal totalGravado);

    BigDecimal getTotalGratuito();
    void setTotalGratuito(BigDecimal totalGratuito);

    BigDecimal getTotalInafecto();
    void setTotalInafecto(BigDecimal totalInafecto);

    BigDecimal getTotalExonerado();
    void setTotalExonerado(BigDecimal totalExonerado);

}
