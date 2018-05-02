package org.openfact.pe.models.jpa;

import org.openfact.pe.models.DatosVentaDetalleModel;
import org.openfact.pe.models.jpa.entities.DatosVentaDetalleEntity;

import java.math.BigDecimal;

public class DatosVentaDetalleAdapter implements DatosVentaDetalleModel {

    private final DatosVentaDetalleEntity detalle;

    public DatosVentaDetalleAdapter(DatosVentaDetalleEntity detalle) {
        this.detalle = detalle;
    }

    @Override
    public String getId() {
        return detalle.getId();
    }

    @Override
    public String getUnidadMedida() {
        return detalle.getUnidadMedida();
    }

    @Override
    public void setUnidadMedida(String unidadMedida) {
        detalle.setUnidadMedida(unidadMedida);
    }

    @Override
    public String getDescripcion() {
        return detalle.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        detalle.setDescripcion(descripcion);
    }

    @Override
    public String getTipoIgv() {
        return detalle.getTipoIgV();
    }

    @Override
    public void setTipoIGV(String tipoIgv) {
        detalle.setTipoIgV(tipoIgv);
    }

    @Override
    public BigDecimal getCantidad() {
        return detalle.getCantidad();
    }

    @Override
    public void setCantidad(BigDecimal cantidad) {
        detalle.setCantidad(cantidad);
    }

    @Override
    public BigDecimal getValorUnitario() {
        return detalle.getValorUnitario();
    }

    @Override
    public void setValorUnitario(BigDecimal valorUnitario) {
        detalle.setValorUnitario(valorUnitario);
    }

    @Override
    public BigDecimal getPrecioUnitario() {
        return detalle.getPrecioUnitario();
    }

    @Override
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        detalle.setPrecioUnitario(precioUnitario);
    }

    @Override
    public BigDecimal getSubtotal() {
        return detalle.getSubtotal();
    }

    @Override
    public void setSubtotal(BigDecimal subtotal) {
        detalle.setSubtotal(subtotal);
    }

    @Override
    public BigDecimal getTotal() {
        return detalle.getTotal();
    }

    @Override
    public void setTotal(BigDecimal total) {
        detalle.setTotal(total);
    }

    @Override
    public BigDecimal getTotalIgv() {
        return detalle.getTotalIgv();
    }

    @Override
    public void setTotalIgv(BigDecimal totalIGV) {
        detalle.setTotalIgv(totalIGV);
    }

    @Override
    public BigDecimal getTotalIsc() {
        return detalle.getTotalIsc();
    }

    @Override
    public void setTotalIsc(BigDecimal totalISC) {
        detalle.setTotalIsc(totalISC);
    }

}
