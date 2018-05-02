package org.openfact.pe.models;

import java.math.BigDecimal;

public class DatosVentaDetalleBean {

    private final String unidadMedida;
    private final String descripcion;
    private final String tipoIgv;
    private final BigDecimal cantidad;
    private final BigDecimal valorUnitario;
    private final BigDecimal precioUnitario;
    private final BigDecimal subtotal;
    private final BigDecimal total;
    private final BigDecimal totalIgv;
    private final BigDecimal totalIsc;

    private DatosVentaDetalleBean(Builder builder) {
        unidadMedida = builder.unidadMedida;
        descripcion = builder.descripcion;
        tipoIgv = builder.tipoIgv;
        cantidad = builder.cantidad;
        valorUnitario = builder.valorUnitario;
        precioUnitario = builder.precioUnitario;
        subtotal = builder.subtotal;
        total = builder.total;
        totalIgv = builder.totalIgv;
        totalIsc = builder.totalIsc;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipoIgv() {
        return tipoIgv;
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

    public BigDecimal getTotalIgv() {
        return totalIgv;
    }

    public BigDecimal getTotalIsc() {
        return totalIsc;
    }

    public static class Builder {
        private String unidadMedida;
        private String descripcion;
        private String tipoIgv;
        private BigDecimal cantidad;
        private BigDecimal valorUnitario;
        private BigDecimal precioUnitario;
        private BigDecimal subtotal;
        private BigDecimal total;
        private BigDecimal totalIgv;
        private BigDecimal totalIsc;

        public DatosVentaDetalleBean build() {
            return new DatosVentaDetalleBean(this);
        }

        public Builder unidadMedida(String unidadMedida) {
            this.unidadMedida = unidadMedida;
            return this;
        }

        public Builder descripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder tipoIgv(String tipoIGV) {
            this.tipoIgv = tipoIGV;
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

        public Builder totalIgv(BigDecimal totalIGV) {
            this.totalIgv = totalIGV;
            return this;
        }

        public Builder totalIsc(BigDecimal totalISC) {
            this.totalIsc = totalISC;
            return this;
        }
    }

}
