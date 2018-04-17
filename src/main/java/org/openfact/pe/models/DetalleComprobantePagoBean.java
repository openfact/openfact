package org.openfact.pe.models;

import java.math.BigDecimal;

public class DetalleComprobantePagoBean {

    private final String unidadMedida;
    private final String descripcion;
    private final String tipoIGV;
    private final BigDecimal cantidad;
    private final BigDecimal valorUnitario;
    private final BigDecimal precioUnitario;
    private final BigDecimal subtotal;
    private final BigDecimal total;
    private final BigDecimal totalIGV;
    private final BigDecimal totalISC;

    private DetalleComprobantePagoBean(Builder builder) {
        unidadMedida = builder.unidadMedida;
        descripcion = builder.descripcion;
        tipoIGV = builder.tipoIGV;
        cantidad = builder.cantidad;
        valorUnitario = builder.valorUnitario;
        precioUnitario = builder.precioUnitario;
        subtotal = builder.subtotal;
        total = builder.total;
        totalIGV = builder.totalIGV;
        totalISC = builder.totalISC;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoIGV() {
        return tipoIGV;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getTotalIGV() {
        return totalIGV;
    }

    public BigDecimal getTotalISC() {
        return totalISC;
    }

    public static class Builder {
        private String unidadMedida;
        private String descripcion;
        private String tipoIGV;
        private BigDecimal cantidad;
        private BigDecimal valorUnitario;
        private BigDecimal precioUnitario;
        private BigDecimal subtotal;
        private BigDecimal total;
        private BigDecimal totalIGV;
        private BigDecimal totalISC;

        public DetalleComprobantePagoBean build() {
            return new DetalleComprobantePagoBean(this);
        }

        public Builder unidadMedida(String unidadMedida) {
            this.unidadMedida = unidadMedida;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder tipoIGV(String tipoIGV) {
            this.tipoIGV = tipoIGV;
            return this;
        }

        public Builder cantidad(BigDecimal cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public Builder valorUnitario(BigDecimal valorUnitario) {
            this.valorUnitario = valorUnitario;
            return this;
        }

        public Builder precioUnitario(BigDecimal precioUnitario) {
            this.precioUnitario = precioUnitario;
            return this;
        }

        public Builder subtotal(BigDecimal subtotal) {
            this.subtotal = subtotal;
            return this;
        }

        public Builder total(BigDecimal total) {
            this.total = total;
            return this;
        }

        public Builder totalIGV(BigDecimal totalIGV) {
            this.totalIGV = totalIGV;
            return this;
        }

        public Builder totalISC(BigDecimal totalISC) {
            this.totalISC = totalISC;
            return this;
        }
    }

}
