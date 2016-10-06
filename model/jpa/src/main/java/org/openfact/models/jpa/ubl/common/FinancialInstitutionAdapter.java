package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.jboss.logging.Logger;
import org.openfact.models.OpenfactSession;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.jpa.entities.ubl.common.FinancialInstitutionEntity;
import org.openfact.models.ubl.common.AddressModel;
import org.openfact.models.ubl.common.FinancialInstitutionModel;

public class FinancialInstitutionAdapter
        implements FinancialInstitutionModel, JpaModel<FinancialInstitutionEntity> {

    protected static final Logger logger = Logger.getLogger(FinancialInstitutionAdapter.class);
    protected FinancialInstitutionEntity financialInstitution;
    protected EntityManager em;
    protected OpenfactSession session;

    public FinancialInstitutionAdapter(OpenfactSession session, EntityManager em,
            FinancialInstitutionEntity financialInstitution) {
        this.session = session;
        this.em = em;
        this.financialInstitution = financialInstitution;
    }

    @Override
    public String getID() {
        return financialInstitution.getID();
    }

    @Override
    public void setID(String value) {
        financialInstitution.setID(value);
    }

    @Override
    public String getName() {
        return financialInstitution.getName();
    }

    @Override
    public void setName(String value) {
        financialInstitution.setName(value);
    }

    @Override
    public AddressModel getAddress() {
        return new AddressAdapter(session, em, financialInstitution.getAddress());
    }

    @Override
    public void setAddress(AddressModel value) {
        financialInstitution.setAddress(AddressAdapter.toEntity(value, em));
    }

    @Override
    public String getId() {
        return financialInstitution.getId();
    }

    public static FinancialInstitutionEntity toEntity(FinancialInstitutionModel model, EntityManager em) {
        if (model instanceof FinancialInstitutionAdapter) {
            return ((FinancialInstitutionAdapter) model).getEntity();
        }
        return em.getReference(FinancialInstitutionEntity.class, model.getId());
    }

    @Override
    public FinancialInstitutionEntity getEntity() {
        return financialInstitution;
    }

}
