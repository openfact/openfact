package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class AbstractInvoiceEntity {

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "file_id")
    private String fileId;

    @Column(name = "cdr_file_id")
    private String cdrFileId;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_sunat")
    private boolean enviarSunat;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_cliente")
    private boolean enviarCliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoComprobantePago estado;

    @Column(name = "estado_descripcion")
    private String estadoDescripcion;

    @Embedded
    private FechaEntity fecha;

    @Embedded
    private ClienteEntity cliente;

    @Embedded
    private MonedaEntity moneda;

    @Embedded
    private TotalEntity total;

    @Embedded
    private TotalInformacionAdicionalEntity totalInformacionAdicional;

    @Embedded
    private ImpuestosEntity impuestos;

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public boolean isEnviarSunat() {
        return enviarSunat;
    }

    public void setEnviarSunat(boolean enviarSUNAT) {
        this.enviarSunat = enviarSUNAT;
    }

    public boolean isEnviarCliente() {
        return enviarCliente;
    }

    public void setEnviarCliente(boolean enviarCliente) {
        this.enviarCliente = enviarCliente;
    }

    public EstadoComprobantePago getEstado() {
        return estado;
    }

    public void setEstado(EstadoComprobantePago estado) {
        this.estado = estado;
    }

    public String getEstadoDescripcion() {
        return estadoDescripcion;
    }

    public void setEstadoDescripcion(String errorDescription) {
        this.estadoDescripcion = errorDescription;
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

    public ClienteEntity getCliente() {
        if (cliente == null) {
            cliente = new ClienteEntity();
        }
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
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

    public TotalEntity getTotal() {
        if (total == null) {
            total = new TotalEntity();
        }
        return total;
    }

    public void setTotal(TotalEntity total) {
        this.total = total;
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

    public ImpuestosEntity getImpuestos() {
        if (impuestos == null) {
            impuestos = new ImpuestosEntity();
        }
        return impuestos;
    }

    public void setImpuestos(ImpuestosEntity impuestos) {
        this.impuestos = impuestos;
    }

    public String getCdrFileId() {
        return cdrFileId;
    }

    public void setCdrFileId(String cdrFileId) {
        this.cdrFileId = cdrFileId;
    }
}
