package org.openfact.pe.models.jpa;

import org.openfact.pe.models.ClienteModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.FacturaModel;
import org.openfact.pe.models.jpa.entities.FacturaEntity;

import java.util.Date;

public abstract class AbstractFacturaAdapter implements FacturaModel {

    protected final FacturaEntity facturaEntity;

    public AbstractFacturaAdapter(FacturaEntity facturaEntity) {
        this.facturaEntity = facturaEntity;
    }

    @Override
    public String getId() {
        return facturaEntity.getId();
    }

    @Override
    public String getSerie() {
        return facturaEntity.getSerie();
    }

    @Override
    public Integer getNumero() {
        return facturaEntity.getNumero();
    }

    @Override
    public EstadoComprobantePago getEstado() {
        return facturaEntity.getEstado();
    }

    @Override
    public Date getFechaEmision() {
        return facturaEntity.getFechaEmision();
    }

    @Override
    public Date getFechaVencimiento() {
        return facturaEntity.getFechaVencimiento();
    }

    @Override
    public String getObservaciones() {
        return facturaEntity.getObservaciones();
    }

    @Override
    public ClienteModel getCliente() {
        return new ClienteAdapter(facturaEntity.getCliente());
    }

    @Override
    public Long getTotalPagar() {
        return facturaEntity.getTotalPagar();
    }

    @Override
    public Long getDescuentoGlobal() {
        return facturaEntity.getDescuentoGlobal();
    }

    @Override
    public Long getOtrosCargos() {
        return facturaEntity.getOtrosCargos();
    }

    @Override
    public String getMoneda() {
        return facturaEntity.getMoneda();
    }

    @Override
    public Long getTipoCambio() {
        return facturaEntity.getTipoCambio();
    }

    @Override
    public Long getTotalIGV() {
        return facturaEntity.getTotalIGV();
    }

    @Override
    public Long getTotalISC() {
        return facturaEntity.getTotalIGV();
    }

    @Override
    public Long getTotalGravada() {
        return facturaEntity.getTotalGravada();
    }

    @Override
    public Long getTotalGratuito() {
        return facturaEntity.getTotalGratuita();
    }

    @Override
    public Long getTotalInafecto() {
        return facturaEntity.getTotalInafecto();
    }

    @Override
    public Long getTotalExonerado() {
        return facturaEntity.getTotalExonerado();
    }

    @Override
    public boolean getEnviarSUNAT() {
        return facturaEntity.isEnviarSUNAT();
    }

    @Override
    public boolean getEnviarCliente() {
        return facturaEntity.isEnviarCliente();
    }

}
