package org.openfact.pe.models;

import java.math.BigDecimal;

public interface DetalleComprobantePagoModel {

    String getId();

    String getUnidadMedida();
    void setUnidadMedida(String unidadMedida);

    String getDescripcion();
    void setDescripcion(String descripcion);

    String getTipoIGV();
    void setTipoIGV(String tipoIGV);

    BigDecimal getCantidad();
    void setCantidad(BigDecimal cantidad);

    BigDecimal getValorUnitario();
    void setValorUnitario(BigDecimal valorUnitario);

    BigDecimal getPrecioUnitario();
    void setPrecioUnitario(BigDecimal precioUnitario);

    BigDecimal getSubtotal();
    void setSubtotal(BigDecimal subtotal);

    BigDecimal getTotal();
    void setTotal(BigDecimal total);

    BigDecimal getTotalIGV();
    void setTotalIGV(BigDecimal totalIGV);

    BigDecimal getTotalISC();
    void setTotalISC(BigDecimal totalISC);
}
