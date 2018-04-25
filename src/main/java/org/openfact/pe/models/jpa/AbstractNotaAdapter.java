package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.JpaModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.*;

import javax.persistence.EntityManager;

public abstract class AbstractNotaAdapter implements NotaModel, JpaModel<NotaEntity> {

    private final EntityManager em;
    private final NotaEntity nota;

    protected AbstractNotaAdapter(EntityManager em, NotaEntity nota) {
        this.em = em;
        this.nota = nota;
    }

    public static NotaEntity toEntity(NotaModel model, EntityManager em) {
        if (model instanceof NotaCreditoAdapter) {
            return ((NotaCreditoAdapter) model).getEntity();
        } else if (model instanceof NotaDebitoAdapter) {
            return ((NotaDebitoAdapter) model).getEntity();
        }
        return em.getReference(NotaEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return nota.getId();
    }

    @Override
    public String getSerie() {
        return nota.getSerie();
    }

    @Override
    public int getNumero() {
        return nota.getNumero();
    }

    @Override
    public String getTipoNota() {
        return nota.getTipoNota();
    }

    @Override
    public void setTipoNota(String tipoNota) {
        nota.setTipoNota(tipoNota);
    }

    @Override
    public InvoiceModel getInvoiceAfectado() {
        InvoiceEntity invoiceEntity = nota.getDocumentoAsociado();

        InvoiceModel invoice;
        if (invoiceEntity instanceof BoletaEntity) {
            invoice = new BoletaAdapter(em, (BoletaEntity) invoiceEntity);
        } else if (invoiceEntity instanceof FacturaEntity) {
            invoice = new FacturaAdapter(em, (FacturaEntity) invoiceEntity);
        } else {
            throw new IllegalStateException("No es una sub clase valida");
        }

        return invoice;
    }

    @Override
    public EstadoComprobantePago getEstado() {
        return nota.getEstado();
    }

    @Override
    public void setEstado(EstadoComprobantePago estado) {
        nota.setEstado(estado);
    }

    @Override
    public String getEstadoDescripcion() {
        return nota.getEstadoDescripcion();
    }

    @Override
    public void setEstadoDescripcion(String estadoDescripcion) {
        nota.setEstadoDescripcion(estadoDescripcion);
    }

    @Override
    public boolean getEnviarSunat() {
        return nota.isEnviarSunat();
    }

    @Override
    public void setEnviarSunat(boolean enviarSunat) {
        nota.setEnviarSunat(enviarSunat);
    }

    @Override
    public boolean getEnviarCliente() {
        return nota.isEnviarCliente();
    }

    @Override
    public void setEnviarCliente(boolean enviarCliente) {
        nota.setEnviarCliente(enviarCliente);
    }

    @Override
    public String getFileId() {
        return nota.getFileId();
    }

    @Override
    public void setFileId(String fileId) {
        nota.setFileId(fileId);
    }

    @Override
    public String getCdrFileId() {
        return nota.getCdrFileId();
    }

    @Override
    public void setCdrFileId(String fileId) {
        nota.setCdrFileId(fileId);
    }

    @Override
    public DatosVentaModel getDatosVenta() {
        return new DatosVentaAdapter(em, nota.getDatosVenta());
    }

    @Override
    public ValidacionModel getValidacion() {
        return new ValidacionAdapter(nota.getValidacion());
    }

    @Override
    public OrganizationModel getOrganization() {
        return new OrganizationAdapter(nota.getOrganization());
    }

}
