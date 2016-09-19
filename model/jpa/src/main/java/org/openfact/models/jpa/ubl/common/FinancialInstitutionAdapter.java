package org.openfact.models.jpa.ubl.common;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
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
        return this.financialInstitution.getID();
    }

    @Override
    public void setID(String value) {
        this.financialInstitution.setID(value);
    }

    @Override
    public String getName() {
        return this.financialInstitution.getName();
    }

    @Override
    public void setName(String value) {
        this.financialInstitution.setName(value);
    }

    @Override
    public AddressModel getAddress() {
        return this.financialInstitution.getAddress();
    }

    @Override
    public void setAddress(AddressAdapter value) {
        this.financialInstitution.setAddress(value);
    }

    @Override
    public String getId() {
        return this.financialInstitution.getId();
    }

    @Override
    public void setId(String value) {
        this.financialInstitution.setId(value);
    }

}
