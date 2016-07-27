package org.openfact.models.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceIdModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.enums.MonetaryTotalType;
import org.openfact.models.jpa.entities.CustomerEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;

public class InvoiceAdapter implements InvoiceModel, JpaModel<InvoiceEntity> {

    protected static final Logger logger = Logger.getLogger(InvoiceAdapter.class);

    protected OrganizationModel organization;
    protected InvoiceEntity invoice;
    protected EntityManager em;
    protected OpenfactSession session;

    public InvoiceAdapter(OpenfactSession session, OrganizationModel organization, EntityManager em,
            InvoiceEntity invoice) {
        this.session = session;
        this.em = em;
        this.organization = organization;
        this.invoice = invoice;
    }

    @Override
    public InvoiceEntity getEntity() {
        return invoice;
    }

    public static InvoiceEntity toEntity(InvoiceModel model, EntityManager em) {
        if (model instanceof InvoiceAdapter) {
            return ((InvoiceAdapter) model).getEntity();
        }
        return em.getReference(InvoiceEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return invoice.getId();
    }

    @Override
    public LocalDate getIssueDate() {
        return invoice.getIssueDate();
    }

    @Override
    public String getCurrencyCode() {
        return invoice.getCurrencyCode();
    }

    @Override
    public InvoiceType getInvoiceType() {
        return invoice.getType();
    }

    @Override
    public InvoiceIdModel getInvoiceId() {
        return new InvoiceIdAdapter(session, this, em, invoice.getInvoiceId());
    }

    @Override
    public void setInvoiceId(InvoiceIdModel invoiceId) {
        invoice.setInvoiceId(InvoiceIdAdapter.toEntity(invoiceId, em));
    }
    
    @Override
    public CustomerModel getCustomer() {
        return new CustomerAdapter(session, this, em, invoice.getCustomer());
    }

    @Override
    public void setCustomer(CustomerModel customer) {
        CustomerEntity customerEntity = CustomerAdapter.toEntity(customer, em);
        invoice.setCustomer(customerEntity);
    }

    @Override
    public Map<AdditionalInformationType, BigDecimal> getAdditionalInformation() {
        return invoice.getAdditionalInformation();
    }

    @Override
    public Map<MonetaryTotalType, BigDecimal> getLegalMonetaryTotal() {
        return invoice.getLegalMonetaryTotal();
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InvoiceAdapter other = (InvoiceAdapter) obj;
        if (invoice == null) {
            if (other.invoice != null)
                return false;
        } else if (!invoice.equals(other.invoice))
            return false;
        return true;
    }   

}
