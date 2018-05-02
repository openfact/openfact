package org.openfact.pe.models.jpa;

import org.openfact.core.models.jpa.JpaModel;
import org.openfact.pe.models.BajaModel;
import org.openfact.pe.models.EstadoComprobantePago;
import org.openfact.pe.models.InvoiceModel;
import org.openfact.pe.models.ValidacionModel;
import org.openfact.pe.models.jpa.entities.BajaEntity;

import javax.persistence.EntityManager;
import java.util.Date;

public class BajaAdapter implements BajaModel, JpaModel<BajaEntity> {

    protected final EntityManager em;
    protected final BajaEntity baja;

    protected BajaAdapter(EntityManager em, BajaEntity baja) {
        this.em = em;
        this.baja = baja;
    }

    public static BajaEntity toEntity(BajaModel model, EntityManager em) {
        if (model instanceof BajaAdapter) {
            return ((BajaAdapter) model).getEntity();
        }
        return em.getReference(BajaEntity.class, model.getId());
    }

    @Override
    public BajaEntity getEntity() {
        return baja;
    }

    @Override
    public String getId() {
        return baja.getId();
    }

    @Override
    public String getSerie() {
        return baja.getSerie();
    }

    @Override
    public int getNumero() {
        return baja.getNumero();
    }

    @Override
    public Date getFechaEmision() {
        return baja.getFechaEmision();
    }

    @Override
    public String getMotivoBaja() {
        return baja.getMotivoBaja();
    }

    @Override
    public void setMotivoBaja(String motivoBaja) {
        baja.setMotivoBaja(motivoBaja);
    }

    @Override
    public EstadoComprobantePago getEstado() {
        return baja.getEstado();
    }

    @Override
    public InvoiceModel getInvoiceAfectado() {
        return new InvoiceAdapter(em, baja.getInvoice());
    }

    @Override
    public String getFileId() {
        return baja.getFileId();
    }

    @Override
    public void setFileId(String fileId) {
        baja.setFileId(fileId);
    }

    @Override
    public String getCdrFileId() {
        return baja.getCdrFileId();
    }

    @Override
    public void setCdrFileId(String fileId) {
        baja.setCdrFileId(fileId);
    }

    @Override
    public boolean getEnviarSunat() {
        return baja.isEnviarSunat();
    }

    @Override
    public void setEnviarSunat(boolean enviarSunat) {
        baja.setEnviarSunat(enviarSunat);
    }

    @Override
    public boolean getEnviarCliente() {
        return baja.isEnviarCliente();
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        baja.setEnviarCliente(enviarCliente);
    }

    @Override
    public ValidacionModel getValidacion() {
        return new ValidacionAdapter(baja.getValidacion());
    }
}
