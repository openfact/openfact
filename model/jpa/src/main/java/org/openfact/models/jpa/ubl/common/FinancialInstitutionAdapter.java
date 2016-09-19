package org.openfact.models.jpa.ubl.common;

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

    String getID() {
        return this.financialInstitution.getID();
    }

    void setID(String value) {
        this.financialInstitution.setID(value);
    }

    String getName() {
        return this.financialInstitution.getName();
    }

    void setName(String value) {
        this.financialInstitution.setName(value);
    }

    AddressAdapter getAddress() {
        return this.financialInstitution.getAddress();
    }

    void setAddress(AddressAdapter value) {
        this.financialInstitution.setAddress(value);
    }

    String getId() {
        return this.financialInstitution.getId();
    }

    void setId(String value) {
        this.financialInstitution.setId(value);
    }

}
