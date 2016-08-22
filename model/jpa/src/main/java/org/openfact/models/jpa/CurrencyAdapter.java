package org.openfact.models.jpa;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.CurrencyModel;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.jpa.entities.CurrencyEntity;

public class CurrencyAdapter implements CurrencyModel, JpaModel<CurrencyEntity> {

    protected static final Logger logger = Logger.getLogger(CurrencyAdapter.class);

    protected OrganizationModel organization;
    protected CurrencyEntity currency;
    protected EntityManager em;
    protected OpenfactSession session;

    public CurrencyAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            CurrencyEntity currency) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.currency = currency;
    }

    @Override
    public CurrencyEntity getEntity() {
        return currency;
    }

    public static CurrencyEntity toEntity(CurrencyModel model, EntityManager em) {
        if (model instanceof CurrencyAdapter) {
            return ((CurrencyAdapter) model).getEntity();
        }
        return em.getReference(CurrencyEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return currency.getId();
    }

    @Override
    public String getCode() {
        return currency.getCode();
    }

    @Override
    public void setCode(String code) {
        currency.setCode(code);
    }

    @Override
    public int getPriority() {
        return currency.getPriority();
    }

    @Override
    public void setPriority(int priority) {
        currency.setPriority(priority);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((currency == null) ? 0 : currency.hashCode());
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
        CurrencyAdapter other = (CurrencyAdapter) obj;
        if (currency == null) {
            if (other.currency != null)
                return false;
        } else if (!currency.equals(other.currency))
            return false;
        return true;
    }

}
