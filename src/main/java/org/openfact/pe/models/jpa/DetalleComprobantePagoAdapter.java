package org.openfact.pe.models.jpa;

import org.openfact.pe.models.DetalleComprobantePagoModel;
import org.openfact.pe.models.jpa.entities.InvoiceLineEntity;

import java.math.BigDecimal;

public class DetalleComprobantePagoAdapter implements DetalleComprobantePagoModel {

    private final InvoiceLineEntity line;

    public DetalleComprobantePagoAdapter(InvoiceLineEntity line) {
        this.line = line;
    }

    @Override
    public String getId() {
        return line.getId();
    }

    @Override
    public String getUnidadMedida() {
        return line.getUnidadMedida();
    }

    @Override
    public void setUnidadMedida(String unidadMedida) {
        line.setUnidadMedida(unidadMedida);
    }

    @Override
    public String getDescripcion() {
        return line.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        line.setDescripcion(descripcion);
    }

    @Override
    public String getTipoIGV() {
        return line.getTipoIGV();
    }

    @Override
    public void setTipoIGV(String tipoIGV) {
        line.setTipoIGV(tipoIGV);
    }

    @Override
    public BigDecimal getCantidad() {
        return line.getCantidad();
    }

    @Override
    public void setCantidad(BigDecimal cantidad) {
        line.setCantidad(cantidad);
    }

    @Override
    public BigDecimal getValorUnitario() {
        return line.getValorUnitario();
    }

    @Override
    public void setValorUnitario(BigDecimal valorUnitario) {
        line.setValorUnitario(valorUnitario);
    }

    @Override
    public BigDecimal getPrecioUnitario() {
        return line.getPrecioUnitario();
    }

    @Override
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        line.setPrecioUnitario(precioUnitario);
    }

    @Override
    public BigDecimal getSubtotal() {
        return line.getSubtotal();
    }

    @Override
    public void setSubtotal(BigDecimal subtotal) {
        line.setSubtotal(subtotal);
    }

    @Override
    public BigDecimal getTotal() {
        return line.getTotal();
    }

    @Override
    public void setTotal(BigDecimal total) {
        line.setTotal(total);
    }

    @Override
    public BigDecimal getTotalIGV() {
        return line.getTotalIGV();
    }

    @Override
    public void setTotalIGV(BigDecimal totalIGV) {
        line.setTotalIGV(totalIGV);
    }

    @Override
    public BigDecimal getTotalISC() {
        return line.getTotalISC();
    }

    @Override
    public void setTotalISC(BigDecimal totalISC) {
        line.setTotalISC(totalISC);
    }

}
