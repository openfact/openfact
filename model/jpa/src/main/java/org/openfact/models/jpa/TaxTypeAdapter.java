package org.openfact.models.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.TaxTypeModel;
import org.openfact.models.jpa.entities.TaxTypeEntity;

public class TaxTypeAdapter implements TaxTypeModel, JpaModel<TaxTypeEntity> {

    protected static final Logger logger = Logger.getLogger(TaxTypeAdapter.class);

    protected OrganizationModel organization;
    protected TaxTypeEntity taxType;
    protected EntityManager em;
    protected OpenfactSession session;

    public TaxTypeAdapter(OrganizationModel organization, OpenfactSession session, EntityManager em,
            TaxTypeEntity taxType) {
        this.organization = organization;
        this.session = session;
        this.em = em;
        this.taxType = taxType;
    }

    @Override
    public TaxTypeEntity getEntity() {
        return taxType;
    }

    public static TaxTypeEntity toEntity(TaxTypeModel model, EntityManager em) {
        if (model instanceof TaxTypeAdapter) {
            return ((TaxTypeAdapter) model).getEntity();
        }
        return em.getReference(TaxTypeEntity.class, model.getId());
    }

    @Override
    public String getId() {
        return taxType.getId();
    }

    @Override
    public String getName() {
        return taxType.getName();
    }

    @Override
    public void setName(String name) {
        taxType.setName(name);
    }

    @Override
    public String getCode() {
        return taxType.getCode();
    }

    @Override
    public void setCode(String code) {
        taxType.setCode(code);
    }

    @Override
    public BigDecimal getValue() {
        return taxType.getValue();
    }

    @Override
    public void setValue(BigDecimal value) {
        taxType.setValue(value);
    }

    @Override
    public OrganizationModel getOrganization() {
        return organization;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((taxType == null) ? 0 : taxType.hashCode());
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
        TaxTypeAdapter other = (TaxTypeAdapter) obj;
        if (taxType == null) {
            if (other.taxType != null)
                return false;
        } else if (!taxType.equals(other.taxType))
            return false;
        return true;
    }

}
