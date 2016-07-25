package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CustomerModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.enums.AdditionalAccountType;
import org.openfact.models.jpa.entities.CustomerEntity;

public class CustomerAdapter implements CustomerModel, JpaModel<CustomerEntity> {

    protected static final Logger logger = Logger.getLogger(CustomerAdapter.class);

    protected CustomerEntity customer;
    protected EntityManager em;
    protected OpenfactSession session;

    public CustomerAdapter(OpenfactSession session, EntityManager em, CustomerEntity customer) {
        this.session = session;
        this.em = em;
        this.customer = customer;
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
    public String getAssignedIdentificationId() {
        return customer.getAssignedIdentificationId();
    }

    @Override
    public void setAssignedIdentificationId(String assignedIdentificationId) {
        customer.setAssignedIdentificationId(assignedIdentificationId);
    }

    @Override
    public AdditionalAccountType getAdditionalAccountId() {
        return customer.getAdditionalAccountId();
    }

    @Override
    public void setAdditionalAccountId(AdditionalAccountType additionalAccountId) {
        customer.setAdditionalAccountId(additionalAccountId);
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
