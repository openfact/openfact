package org.openfact.pe.models.jpa;

import org.openfact.pe.models.jpa.entities.BoletaEntity;

import javax.persistence.EntityManager;
import java.util.Date;

public class BoletaAdapter extends AbstractBoletaAdapter {

    private final EntityManager em;

    public BoletaAdapter(EntityManager em, BoletaEntity boletaEntity) {
        super(boletaEntity);
        this.em = em;
    }

    @Override
    public void setFechaEmision(Date fechaEmision) {
        boletaEntity.setFechaEmision(fechaEmision);
    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {
        boletaEntity.setFechaVencimiento(fechaVencimiento);
    }

    @Override
    public void setFileId(String fileId) {
        boletaEntity.setFileId(fileId);
    }

    @Override
    public void setFileProvider(String fileProvider) {
        boletaEntity.setFileProvider(fileProvider);
    }

    @Override
    public void setTotalPagar(Long totalPagar) {
        boletaEntity.setTotalPagar(totalPagar);
    }

    @Override
    public void setDescuentoGlobal(Long descuentoGlobal) {
        boletaEntity.setDescuentoGlobal(descuentoGlobal);
    }

    @Override
    public void setOtrosCargos(Long otrosCargos) {
        boletaEntity.setOtrosCargos(otrosCargos);
    }

    @Override
    public void setMoneda(String moneda) {
        boletaEntity.setMoneda(moneda);
    }

    @Override
    public void setTipoCambio(Long tipoCambio) {
        boletaEntity.setTipoCambio(tipoCambio);
    }

    @Override
    public void setTotalIGV(Long IGV) {
        boletaEntity.setTotalIGV(IGV);
    }

    @Override
    public void setTotalISC(Long ISC) {
        boletaEntity.setTotalISC(ISC);
    }

    @Override
    public void setTotalGravada(Long totalGravada) {
        boletaEntity.setTotalGravada(totalGravada);
    }

    @Override
    public void setTotalGratuito(Long totalGratuita) {
        boletaEntity.setTotalGratuita(totalGratuita);
    }

    @Override
    public void setTotalInafecto(Long totalInafecto) {
        boletaEntity.setTotalInafecto(totalInafecto);
    }

    @Override
    public void setTotalExonerado(Long totalExonerado) {
        boletaEntity.setTotalExonerado(totalExonerado);
    }

    @Override
    public void setEnviarSUNAT(boolean enviarSUNAT) {
        boletaEntity.setEnviarSUNAT(enviarSUNAT);
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        boletaEntity.setEnviarCliente(enviarCliente);
    }

}
