package org.openfact.pe.models.jpa.entities;

import org.hibernate.annotations.Type;
import org.openfact.pe.models.EstadoComprobantePago;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractInvoiceEntity {

    @Column(name = "file_id")
    private String fileId;

    @Column(name = "file_provider")
    private String fileProvider;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    @Column(name = "total_pagar")
    private Long totalPagar;

    @Column(name = "descuento_global")
    private Long descuentoGlobal;

    @Column(name = "otros_cargos")
    private Long otrosCargos;

    @Column(name = "moneda")
    private String moneda;

    @Column(name = "tipo_cambio")
    private Long tipoCambio;

    @Column(name = "total_igv")
    private Long totalIGV;

    @Column(name = "total_isc")
    private Long totalISC;

    @Column(name = "total_gravada")
    private Long totalGravada;

    @Column(name = "total_gratuita")
    private Long totalGratuita;

    @Column(name = "total_inafecto")
    private Long totalInafecto;

    @Column(name = "total_exonerado")
    private Long totalExonerado;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_sunat")
    private boolean enviarSUNAT;

    @Type(type = "org.hibernate.type.YesNoType")
    @Column(name = "enviar_cliente")
    private boolean enviarCliente;

    @Column(name = "observaciones")
    private String observaciones;

    @Embedded
    private ClienteEntity cliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoComprobantePago estado;

    @Column(name = "error_description")
    private String errorDescription;

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(Long totalPagar) {
        this.totalPagar = totalPagar;
    }

    public Long getDescuentoGlobal() {
        return descuentoGlobal;
    }

    public void setDescuentoGlobal(Long descuentoGlobal) {
        this.descuentoGlobal = descuentoGlobal;
    }

    public Long getOtrosCargos() {
        return otrosCargos;
    }

    public void setOtrosCargos(Long otrosCargos) {
        this.otrosCargos = otrosCargos;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Long getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(Long tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public Long getTotalIGV() {
        return totalIGV;
    }

    public void setTotalIGV(Long totalIGV) {
        this.totalIGV = totalIGV;
    }

    public Long getTotalISC() {
        return totalISC;
    }

    public void setTotalISC(Long totalISC) {
        this.totalISC = totalISC;
    }

    public Long getTotalGravada() {
        return totalGravada;
    }

    public void setTotalGravada(Long totalGravada) {
        this.totalGravada = totalGravada;
    }

    public Long getTotalGratuita() {
        return totalGratuita;
    }

    public void setTotalGratuita(Long totalGratuita) {
        this.totalGratuita = totalGratuita;
    }

    public Long getTotalInafecto() {
        return totalInafecto;
    }

    public void setTotalInafecto(Long totalInafecta) {
        this.totalInafecto = totalInafecta;
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

    public ClienteEntity getCliente() {
        if (cliente == null) {
            cliente = new ClienteEntity();
        }
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public EstadoComprobantePago getEstado() {
        return estado;
    }

    public void setEstado(EstadoComprobantePago estado) {
        this.estado = estado;
    }

    public Long getTotalExonerado() {
        return totalExonerado;
    }

    public void setTotalExonerado(Long totalExonerado) {
        this.totalExonerado = totalExonerado;
    }

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

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
