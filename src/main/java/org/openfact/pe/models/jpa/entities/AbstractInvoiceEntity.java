package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.pe.idm.FechaRepresentation;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractInvoiceEntity {

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "file_id")
    private String fileId;

    @Column(name = "file_provider")
    private String fileProvider;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_sunat")
    private boolean enviarSUNAT;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_cliente")
    private boolean enviarCliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoComprobantePago estado;

    @Column(name = "error_description")
    private String errorDescription;

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

    public String getFileProvider() {
        return fileProvider;
    }

    public void setFileProvider(String fileProvider) {
        this.fileProvider = fileProvider;
    }

    public boolean isEnviarSUNAT() {
        return enviarSUNAT;
    }

    public void setEnviarSUNAT(boolean enviarSUNAT) {
        this.enviarSUNAT = enviarSUNAT;
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

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
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
}
