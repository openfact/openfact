package org.openfact.pe.models;

import java.math.BigDecimal;

public interface DatosVentaDetalleModel {

    String getId();

    String getUnidadMedida();
    void setUnidadMedida(String unidadMedida);

    String getDescripcion();
    void setDescripcion(String descripcion);

    String getTipoIgv();
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

    BigDecimal getTotalIgv();
    void setTotalIgv(BigDecimal totalIGV);

    BigDecimal getTotalIsc();
    void setTotalIsc(BigDecimal totalISC);
}
