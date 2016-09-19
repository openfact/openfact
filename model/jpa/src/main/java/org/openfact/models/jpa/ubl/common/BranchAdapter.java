package org.openfact.models.jpa.ubl.common;

public class BranchAdapter implements BranchModel, JpaModel<BranchEntity> {

    protected static final Logger logger = Logger.getLogger(BranchAdapter.class);
    protected BranchEntity branch;
    protected EntityManager em;
    protected OpenfactSession session;

    public BranchAdapter(OpenfactSession session, EntityManager em, BranchEntity branch) {
        this.session = session;
        this.em = em;
        this.branch = branch;
    }

    String getID() {
        return this.branch.getID();
    }

    void setID(String value) {
        this.branch.setID(value);
    }

    String getName() {
        return this.branch.getName();
    }

    void setName(String value) {
        this.branch.setName(value);
    }

    FinancialInstitutionAdapter getFinancialInstitution() {
        return this.branch.getFinancialInstitution();
    }

    void setFinancialInstitution(FinancialInstitutionAdapter value) {
        this.branch.setFinancialInstitution(value);
    }

    AddressAdapter getAddress() {
        return this.branch.getAddress();
    }

    void setAddress(AddressAdapter value) {
        this.branch.setAddress(value);
    }

    String getId() {
        return this.branch.getId();
    }

    void setId(String value) {
        this.branch.setId(value);
    }

}
