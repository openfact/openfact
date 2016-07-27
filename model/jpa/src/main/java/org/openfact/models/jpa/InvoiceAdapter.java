package org.openfact.models.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerModel;
import org.openfact.models.InvoiceIdModel;
import org.openfact.models.InvoiceLineModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.AdditionalInformationType;
import org.openfact.models.enums.InvoiceType;
import org.openfact.models.enums.MonetaryTotalType;
import org.openfact.models.enums.TaxType;
import org.openfact.models.jpa.entities.CustomerEntity;
import org.openfact.models.jpa.entities.InvoiceEntity;
import org.openfact.models.jpa.entities.InvoiceIdEntity;
import org.openfact.models.jpa.entities.InvoiceLineEntity;

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
    public void addAdditionalInformation(AdditionalInformationType type, BigDecimal ammount) {
        invoice.getAdditionalInformation().put(type, ammount);
    }


    @Override
    public Map<TaxType, BigDecimal> getTotalTaxs() {
        return invoice.getTaxTotal();
    }

    @Override
    public void addTotalTax(TaxType type, BigDecimal ammount) {
        invoice.getTaxTotal().put(type, ammount);
    }
    
    @Override
    public Map<MonetaryTotalType, BigDecimal> getLegalMonetaryTotal() {
        return invoice.getLegalMonetaryTotal();
    }

    @Override
    public void addLegalMonetaryTotal(MonetaryTotalType type, BigDecimal ammount) {
        invoice.getLegalMonetaryTotal().put(type, ammount);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public InvoiceIdModel registerInvoiceId(InvoiceModel invoice, int series, int number) {
        if (series == -1 && number == -1) {
            Query querySet = em.createNamedQuery("getLastInvoiceIdSeriesByOrganization");
            querySet.setParameter("organizationId", invoice.getOrganization().getId());
            Number lastSeries = (Number) querySet.getSingleResult();
            series = lastSeries != null ? lastSeries.intValue() : 0;

            Query queryNumber = em.createNamedQuery("getLastInvoiceIdNumberOfSeriesByOrganization");
            queryNumber.setParameter("organizationId", invoice.getOrganization().getId());
            queryNumber.setParameter("series", lastSeries);
            Number lastNumber = (Number) queryNumber.getSingleResult();
            number = lastNumber != null ? lastNumber.intValue() : 0;

            if (series == 0) {
                series++;
            }
            if (number < 9999) {
                number++;
            } else {
                series++;
                number = 1;
            }
        }
        
        if(session.invoices().getInvoiceBySeriesAndNumber(series, number, invoice.getOrganization()) != null) {
            throw new ModelDuplicateException("Invoice series and number existed");
        }

        InvoiceIdEntity entity = new InvoiceIdEntity();
        entity.setSeries(series);
        entity.setNumber(number);
        entity.setInvoice(InvoiceAdapter.toEntity(invoice, em));
        em.persist(entity);
        em.flush();
        return new InvoiceIdAdapter(session, invoice, em, entity);
    }
    
    @Override
    public CustomerModel registerCustomer(InvoiceModel invoice, String registrationName) {
        CustomerEntity entity = new CustomerEntity();
        entity.setRegistrationName(registrationName);        
        entity.setInvoice(InvoiceAdapter.toEntity(invoice, em));       
        em.persist(entity);
        em.flush();
        return new CustomerAdapter(session, invoice, em, entity);
    }        
    
    @Override
    public List<InvoiceLineModel> getInvoiceLines() {
        List<InvoiceLineModel> invoiceLines = new ArrayList<>();
        List<InvoiceLineEntity> entities = invoice.getInvoiceLines();
        entities.forEach(f -> invoiceLines.add(new InvoiceLineAdapter(session, this, em, f)));
        return invoiceLines;
    }

    @Override
    public InvoiceLineModel addInvoiceLine(BigDecimal price, double quantity, String unitCode,  String itemDescription, Map<TaxType, BigDecimal> taxs) {
        InvoiceLineEntity entity = new InvoiceLineEntity();
        entity.setOrderNumber(invoice.getInvoiceLines().size() + 1);
        entity.setPrice(price);
        entity.setQuantity(quantity);
        entity.setUnitCode(unitCode);
        entity.setItemDescription(itemDescription);
        entity.setTaxs(taxs);
        entity.setInvoice(invoice);
        em.persist(entity);
        em.flush();
        final InvoiceLineModel adapter = new InvoiceLineAdapter(session, this, em, entity);
        return adapter;        
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
