package org.openfact.pe.models.jpa;

import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.jpa.entities.FacturaEntity;

import javax.persistence.EntityManager;
import java.util.Date;

public class FacturaAdapter extends AbstractFacturaAdapter {

    private final EntityManager em;

    public FacturaAdapter(EntityManager em, FacturaEntity facturaEntity) {
        super(facturaEntity);
        this.em = em;
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        facturaEntity.setEstado(estado);
    }

    @Override
    public void setError(String error) {
        facturaEntity.setErrorDescription(error);
    }

    @Override
    public void setFechaEmision(Date fechaEmision) {
        facturaEntity.setFechaEmision(fechaEmision);
    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {
        facturaEntity.setFechaVencimiento(fechaVencimiento);
    }

    @Override
    public void setObservaciones(String observaciones) {
        facturaEntity.setObservaciones(observaciones);
    }

    @Override
    public void setFileId(String fileId) {
        facturaEntity.setFileId(fileId);
    }

    @Override
    public void setFileProvider(String fileProvider) {
        facturaEntity.setFileProvider(fileProvider);
    }

    @Override
    public void setTotalPagar(Long totalPagar) {
        facturaEntity.setTotalPagar(totalPagar);
    }

    @Override
    public void setDescuentoGlobal(Long descuentoGlobal) {
        facturaEntity.setDescuentoGlobal(descuentoGlobal);
    }

    @Override
    public void setOtrosCargos(Long otrosCargos) {
        facturaEntity.setOtrosCargos(otrosCargos);
    }

    @Override
    public void setMoneda(String moneda) {
        facturaEntity.setMoneda(moneda);
    }

    @Override
    public void setTipoCambio(Long tipoCambio) {
        facturaEntity.setTipoCambio(tipoCambio);
    }

    @Override
    public void setTotalIGV(Long IGV) {
        facturaEntity.setTotalIGV(IGV);
    }

    @Override
    public void setTotalISC(Long ISC) {
        facturaEntity.setTotalISC(ISC);
    }

    @Override
    public void setTotalGravada(Long totalGravada) {
        facturaEntity.setTotalGravada(totalGravada);
    }

    @Override
    public void setTotalGratuito(Long totalGratuita) {
        facturaEntity.setTotalGratuita(totalGratuita);
    }

    @Override
    public void setTotalInafecto(Long totalInafecto) {
        facturaEntity.setTotalInafecto(totalInafecto);
    }

    @Override
    public void setTotalExonerado(Long totalExonerado) {
        facturaEntity.setTotalExonerado(totalExonerado);
    }

    @Override
    public void setEnviarSUNAT(boolean enviarSUNAT) {
        facturaEntity.setEnviarSUNAT(enviarSUNAT);
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        facturaEntity.setEnviarCliente(enviarCliente);
    }

}
