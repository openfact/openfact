package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.JpaModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.InvoiceEntity;

import javax.persistence.EntityManager;

public abstract class AbstractInvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntity> {

    protected final EntityManager em;
    protected final InvoiceEntity invoice;

    protected AbstractInvoiceAdapter(EntityManager em, InvoiceEntity invoice) {
        this.em = em;
        this.invoice = invoice;
    }

    public static InvoiceEntity toEntity(InvoiceModel model, EntityManager em) {
        if (model instanceof BoletaAdapter) {
            return ((BoletaAdapter) model).getEntity();
        } else if (model instanceof FacturaAdapter) {
            return ((FacturaAdapter) model).getEntity();
        }
        return em.getReference(InvoiceEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return invoice.getId();
    }

    @Override
    public String getSerie() {
        return invoice.getSerie();
    }

    @Override
    public int getNumero() {
        return invoice.getNumero();
    }

    @Override
    public EstadoComprobantePago getEstado() {
        return invoice.getEstado();
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        invoice.setEstado(estado);
    }

    @Override
    public String getEstadoDescripcion() {
        return invoice.getEstadoDescripcion();
    }

    @Override
    public void setEstadoDescripcion(String estadoDescripcion) {
        invoice.setEstadoDescripcion(estadoDescripcion);
    }

    @Override
    public boolean getEnviarSunat() {
        return invoice.isEnviarSunat();
    }

    @Override
    public void setEnviarSunat(boolean enviarSunat) {
        invoice.setEnviarSunat(enviarSunat);
    }

    @Override
    public boolean getEnviarCliente() {
        return invoice.isEnviarCliente();
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        invoice.setEnviarCliente(enviarCliente);
    }

    @Override
    public String getFileId() {
        return invoice.getFileId();
    }

    @Override
    public void setFileId(String fileId) {
        invoice.setFileId(fileId);
    }

    @Override
    public String getCdrFileId() {
        return invoice.getCdrFileId();
    }

    @Override
    public void setCdrFileId(String fileId) {
        invoice.setCdrFileId(fileId);
    }

    @Override
    public DatosVentaModel getDatosVenta() {
        return new DatosVentaAdapter(em, invoice.getDatosVenta());
    }

    @Override
    public ValidacionModel getValidacion() {
        return new ValidacionAdapter(invoice.getValidacion());
    }

    @Override
    public OrganizationModel getOrganization() {
        return new OrganizationAdapter(invoice.getOrganization());
    }

}
