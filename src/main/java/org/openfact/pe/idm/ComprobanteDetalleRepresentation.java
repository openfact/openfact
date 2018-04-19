package org.openfact.pe.idm;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ComprobanteDetalleRepresentation {

    @NotNull
    private String unidadMedida;

    @NotNull
    private String descripcion;

    @NotNull
    private String tipoIGV;

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
    private BigDecimal totalIGV;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalISC;

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

    public String getTipoIGV() {
        return tipoIGV;
    }

    public void setTipoIGV(String tipoIGV) {
        this.tipoIGV = tipoIGV;
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

    public BigDecimal getTotalIGV() {
        return totalIGV;
    }

    public void setTotalIGV(BigDecimal totalIGV) {
        this.totalIGV = totalIGV;
    }

    public BigDecimal getTotalISC() {
        return totalISC;
    }

    public void setTotalISC(BigDecimal totalISC) {
        this.totalISC = totalISC;
    }
}
