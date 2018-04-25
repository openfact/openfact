package org.openfact.pe.models.jpa.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "datos_venta")
public class DatosVentaEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "id")
    private String id;

    @Column(name = "observaciones")
    private String observaciones;

    @Embedded
    private TotalEntity total;

    @Embedded
    private FechaEntity fecha;

    @Embedded
    private MonedaEntity moneda;

    @Embedded
    private ClienteEntity cliente;

    @Embedded
    private ImpuestosEntity impuestos;

    @Embedded
    private TotalInformacionAdicionalEntity totalInformacionAdicional;

    @OneToMany(mappedBy = "datosVenta", fetch = FetchType.LAZY)
    private List<DatosVentaDetalleEntity> detalle = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TotalEntity getTotal() {
        if (total == null) {
            total = new TotalEntity();
        }
        return total;
    }

    public void setTotal(TotalEntity total) {
        this.total = total;
    }

    public FechaEntity getFecha() {
        if (fecha == null) {
            fecha = new FechaEntity();
        }
        return fecha;
    }

    public void setFecha(FechaEntity fecha) {
        this.fecha = fecha;
    }

    public MonedaEntity getMoneda() {
        if (moneda == null) {
            moneda = new MonedaEntity();
        }
        return moneda;
    }

    public void setMoneda(MonedaEntity moneda) {
        this.moneda = moneda;
    }

    public ClienteEntity getCliente() {
        if (cliente == null) {
            cliente = new ClienteEntity();
        }
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public ImpuestosEntity getImpuestos() {
        if (impuestos == null) {
            impuestos = new ImpuestosEntity();
        }
        return impuestos;
    }

    public void setImpuestos(ImpuestosEntity impuestos) {
        this.impuestos = impuestos;
    }

    public TotalInformacionAdicionalEntity getTotalInformacionAdicional() {
        if (totalInformacionAdicional == null) {
            totalInformacionAdicional = new TotalInformacionAdicionalEntity();
        }
        return totalInformacionAdicional;
    }

    public void setTotalInformacionAdicional(TotalInformacionAdicionalEntity totalInformacionAdicional) {
        this.totalInformacionAdicional = totalInformacionAdicional;
    }

    public List<DatosVentaDetalleEntity> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DatosVentaDetalleEntity> detalle) {
        this.detalle = detalle;
    }
}
