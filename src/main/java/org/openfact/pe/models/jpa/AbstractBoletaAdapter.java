package org.openfact.pe.models.jpa;

import org.openfact.pe.models.BoletaModel;
import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.jpa.entities.BoletaEntity;

import java.util.Date;

public abstract class AbstractBoletaAdapter implements BoletaModel {

    protected final BoletaEntity boletaEntity;

    public AbstractBoletaAdapter(BoletaEntity boletaEntity) {
        this.boletaEntity = boletaEntity;
    }

    @Override
    public String getId() {
        return boletaEntity.getId();
    }

    @Override
    public String getFileId() {
        return boletaEntity.getFileId();
    }

    @Override
    public String getFileProvider() {
        return boletaEntity.getFileProvider();
    }

    @Override
    public String getSerie() {
        return boletaEntity.getSerie();
    }

    @Override
    public Integer getNumero() {
        return boletaEntity.getNumero();
    }

    @Override
    public EstadoComprobantePago getEstado() {
        return boletaEntity.getEstado();
    }

    @Override
    public String getError() {
        return boletaEntity.getErrorDescription();
    }

    @Override
    public Date getFechaEmision() {
        return boletaEntity.getFechaEmision();
    }

    @Override
    public Date getFechaVencimiento() {
        return boletaEntity.getFechaVencimiento();
    }

    @Override
    public String getObservaciones() {
        return boletaEntity.getObservaciones();
    }

    @Override
    public ClienteModel getCliente() {
        return new ClienteAdapter(boletaEntity.getCliente());
    }

    @Override
    public Long getTotalPagar() {
        return boletaEntity.getTotalPagar();
    }

    @Override
    public Long getDescuentoGlobal() {
        return boletaEntity.getDescuentoGlobal();
    }

    @Override
    public Long getOtrosCargos() {
        return boletaEntity.getOtrosCargos();
    }

    @Override
    public String getMoneda() {
        return boletaEntity.getMoneda();
    }

    @Override
    public Long getTipoCambio() {
        return boletaEntity.getTipoCambio();
    }

    @Override
    public Long getTotalIGV() {
        return boletaEntity.getTotalIGV();
    }

    @Override
    public Long getTotalISC() {
        return boletaEntity.getTotalIGV();
    }

    @Override
    public Long getTotalGravada() {
        return boletaEntity.getTotalGravada();
    }

    @Override
    public Long getTotalGratuito() {
        return boletaEntity.getTotalGratuita();
    }

    @Override
    public Long getTotalInafecto() {
        return boletaEntity.getTotalInafecto();
    }

    @Override
    public Long getTotalExonerado() {
        return boletaEntity.getTotalExonerado();
    }

    @Override
    public boolean getEnviarSUNAT() {
        return boletaEntity.isEnviarSUNAT();
    }

    @Override
    public boolean getEnviarCliente() {
        return boletaEntity.isEnviarCliente();
    }

}
