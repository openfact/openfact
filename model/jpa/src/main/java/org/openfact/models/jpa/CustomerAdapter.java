package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerModel;
import org.openfact.models.DocumentSnapshotModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.entities.CustomerEntity;
import org.openfact.models.jpa.entities.DocumentSnapshotEntity;

public class CustomerAdapter implements CustomerModel, JpaModel<CustomerEntity> {

    protected static final Logger logger = Logger.getLogger(CustomerAdapter.class);

    protected InvoiceModel invoice;
    protected CustomerEntity customer;
    protected EntityManager em;
    protected OpenfactSession session;

    public CustomerAdapter(OpenfactSession session, InvoiceModel invoice, EntityManager em,
            CustomerEntity customer) {
        this.session = session;
        this.em = em;
        this.customer = customer;
        this.invoice = invoice;
    }

    @Override
    public CustomerEntity getEntity() {
        return customer;
    }

    public static CustomerEntity toEntity(CustomerModel model, EntityManager em) {
        if (model instanceof CustomerAdapter) {
            return ((CustomerAdapter) model).getEntity();
        }
        return em.getReference(CustomerEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return customer.getId();
    }

    @Override
    public String getRegistrationName() {
        return customer.getRegistrationName();
    }

    @Override
    public void setRegistrationName(String registrationName) {
        customer.setRegistrationName(registrationName);
    }
    
    @Override
    public String getAssignedIdentificationId() {
        return customer.getAssignedIdentificationId();
    }

    @Override
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        customer.setAssignedIdentificationId(assignedIdentificationId);
    }    

    @Override
    public String getAdditionalAccountIdName() {
        return customer.getAdditionalAccountId().getName();
    }

    @Override
    public void setAdditionalAccountIdName(String additionalAccountIdName) {
        customer.getAdditionalAccountId().setName(additionalAccountIdName);
    }

    @Override
    public String getAdditionalAccountId_Id() {
        if(customer.getAdditionalAccountId() != null) {
            return customer.getAdditionalAccountId().getDocumentId();    
        }
        return null;
    }

    @Override
    public void setAdditionalAccountId_Id(String additionalAccountId) {
        if(customer.getAdditionalAccountId() != null) {
            customer.getAdditionalAccountId().setDocumentId(additionalAccountId);    
        } else {
            DocumentSnapshotEntity document = new DocumentSnapshotEntity();
            document.setDocumentId(additionalAccountId);
            customer.setAdditionalAccountId(document);
        }        
    }
    
    @Override
    public String getEmail() {
        return customer.getEmail();
    }

    @Override
    public void setEmail(String email) {
        customer.setEmail(email);
    }

    @Override
    public InvoiceModel getInvoice() {
        return invoice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
        CustomerAdapter other = (CustomerAdapter) obj;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        return true;
    }    

}
