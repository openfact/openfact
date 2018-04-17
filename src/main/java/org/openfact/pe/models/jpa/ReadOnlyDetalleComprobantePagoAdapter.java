package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.InvoiceLineEntity;

import java.math.BigDecimal;

public class ReadOnlyDetalleComprobantePagoAdapter extends DetalleComprobantePagoAdapter {

    public ReadOnlyDetalleComprobantePagoAdapter(InvoiceLineEntity line) {
        super(line);
    }

    @Override
    public void setCantidad(BigDecimal cantidad) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setDescripcion(String descripcion) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setSubtotal(BigDecimal subtotal) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTipoIGV(String tipoIGV) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTotal(BigDecimal total) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTotalIGV(BigDecimal totalIGV) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setTotalISC(BigDecimal totalISC) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setUnidadMedida(String unidadMedida) {
        ReadOnlyUtils.throwException();
    }

    @Override
    public void setValorUnitario(BigDecimal valorUnitario) {
        ReadOnlyUtils.throwException();
    }

}
