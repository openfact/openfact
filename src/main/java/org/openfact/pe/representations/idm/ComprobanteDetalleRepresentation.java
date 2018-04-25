package org.openfact.pe.representations.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ComprobanteDetalleRepresentation {

    @NotNull
    private String unidadMedida;

    @NotNull
    private String descripcion;

    @NotNull
    private String tipoIgv;

    @NotNull
    @Digits(integer = 10, fraction = 3)
    private BigDecimal cantidad;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valorUnitario;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precioUnitario;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal subtotal;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal total;

    @NotNull
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalIgv;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalIsc;

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoIgv() {
        return tipoIgv;
    }

    public void setTipoIgv(String tipoIgv) {
        this.tipoIgv = tipoIgv;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalIgv() {
        return totalIgv;
    }

    public void setTotalIgv(BigDecimal totalIgv) {
        this.totalIgv = totalIgv;
    }

    public BigDecimal getTotalIsc() {
        return totalIsc;
    }

    public void setTotalIsc(BigDecimal totalIsc) {
        this.totalIsc = totalIsc;
    }
}
