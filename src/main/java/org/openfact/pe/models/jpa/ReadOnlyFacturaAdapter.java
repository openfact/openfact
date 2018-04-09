package org.openfact.pe.models.jpa;

import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.jpa.entities.FacturaEntity;

import javax.persistence.EntityManager;
import java.util.Date;

public class ReadOnlyFacturaAdapter extends AbstractFacturaAdapter {

    public ReadOnlyFacturaAdapter(EntityManager em, FacturaEntity entity) {
        super(entity);
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setError(String error) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setFechaEmision(Date fechaEmision) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setFechaVencimiento(Date fechaVencimiento) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setObservaciones(String observaciones) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setFileId(String fileId) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setFileProvider(String fileProvider) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTotalPagar(Long pagar) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setDescuentoGlobal(Long descuentoGlobal) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setOtrosCargos(Long otrosCargos) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setMoneda(String moneda) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTipoCambio(Long tipoCambio) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTotalIGV(Long IGV) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTotalISC(Long ISC) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTotalGravada(Long totalGravada) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTotalGratuito(Long totalGratuita) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTotalInafecto(Long totalInafecta) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setTotalExonerado(Long totalExonerada) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setEnviarSUNAT(boolean enviarSUNAT) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        throw new IllegalStateException("Objeto de solo lectura, no puede ser modificado");
    }


}
