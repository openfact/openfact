package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "datos_venta_detalle")
@NamedQueries(value = {
        @NamedQuery(name = "deleteDatosVentaDetalle", query = "delete from DatosVentaDetalleEntity d where d.datosVenta.id=:datosVentaId")
})
public class DatosVentaDetalleEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "unidad_medida")
    private String unidadMedida;

    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @NotNull
    @Column(name = "tipo_igv")
    private String tipoIgV;

    @NotNull
    @Column(name = "cantidad")
    @Digits(integer = 10, fraction = 3)
    private BigDecimal cantidad;

    @NotNull
    @Column(name = "valor_unitario")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal valorUnitario;

    @NotNull
    @Column(name = "precio_unitario")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal precioUnitario;

    @NotNull
    @Column(name = "subtotal")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal subtotal;

    @NotNull
    @Column(name = "total")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal total;

    @NotNull
    @Column(name = "total_igv")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalIgv;

    @Column(name = "total_isc")
    @Digits(integer = 10, fraction = 2)
    private BigDecimal totalIsc;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "datos_venta_id")
    private DatosVentaEntity datosVenta;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getTipoIgV() {
        return tipoIgV;
    }

    public void setTipoIgV(String tipoIgV) {
        this.tipoIgV = tipoIgV;
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

    public DatosVentaEntity getDatosVenta() {
        return datosVenta;
    }

    public void setDatosVenta(DatosVentaEntity datosVenta) {
        this.datosVenta = datosVenta;
    }
}
