package org.openfact.pe.models.jpa;

import org.openfact.core.models.OrganizationModel;
import org.openfact.core.models.jpa.JpaModel;
import org.openfact.core.models.jpa.OrganizationAdapter;
import org.openfact.pe.models.*;
import org.openfact.pe.models.jpa.entities.InvoiceEntity;
import org.openfact.pe.models.jpa.entities.ResumenDiarioEntity;

import javax.persistence.EntityManager;
import java.util.Optional;

public class InvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntity> {

    protected final EntityManager em;
    protected final InvoiceEntity invoice;

    protected InvoiceAdapter(EntityManager em, InvoiceEntity invoice) {
        this.em = em;
        this.invoice = invoice;
    }

    public static InvoiceEntity toEntity(InvoiceModel model, EntityManager em) {
        if (model instanceof InvoiceAdapter) {
            return ((InvoiceAdapter) model).getEntity();
        }
        return em.getReference(InvoiceEntity.class, model.getId());
    }

    @Override
    public InvoiceEntity getEntity() {
        return invoice;
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
    public String getCodigoTipoComprobante() {
        return invoice.getCodigoTipoComprobante();
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
    public CdrModel getCdr() {
        return new CdrAdapter(invoice.getCdr());
    }

    @Override
    public DatosVentaModel getDatosVenta() {
        return new DatosVentaAdapter(em, invoice.getDatosVenta());
    }

    @Override
    public EstadoSunatModel getEstadoSunat() {
        return new EstadoSunatAdapter(invoice.getEstadoSunat());
    }

    @Override
    public OrganizationModel getOrganization() {
        return new OrganizationAdapter(invoice.getOrganization());
    }

    @Override
    public Optional<ResumenDiarioModel> getResumenDiario() {
        ResumenDiarioEntity resumenDiario = invoice.getResumenDiario();
        if (resumenDiario == null) return Optional.empty();
        return Optional.of(new ResumenDiarioAdapter(resumenDiario));
    }


}
