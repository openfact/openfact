package org.openfact.models.jpa.ubl.common;

import java.util.List;

public class FinancialAccountAdapter implements FinancialAccountModel, JpaModel<FinancialAccountEntity> {

    protected static final Logger logger = Logger.getLogger(FinancialAccountAdapter.class);
    protected FinancialAccountEntity financialAccount;
    protected EntityManager em;
    protected OpenfactSession session;

    public FinancialAccountAdapter(OpenfactSession session, EntityManager em,
            FinancialAccountEntity financialAccount) {
        this.session = session;
        this.em = em;
        this.financialAccount = financialAccount;
    }

    String getID() {
        return this.financialAccount.getID();
    }

    void setID(String value) {
        this.financialAccount.setID(value);
    }

    String getName() {
        return this.financialAccount.getName();
    }

    void setName(String value) {
        this.financialAccount.setName(value);
    }

    String getAccountAdapterCode() {
        return this.financialAccount.getAccountAdapterCode();
    }

    void setAccountAdapterCode(String value) {
        this.financialAccount.setAccountAdapterCode(value);
    }

    String getCurrencyCode() {
        return this.financialAccount.getCurrencyCode();
    }

    void setCurrencyCode(String value) {
        this.financialAccount.setCurrencyCode(value);
    }

    List<String> getPaymentNote() {
        return this.financialAccount.getPaymentNote();
    }

    void setPaymentNote(List<String> paymentNote) {
        this.financialAccount.setPaymentNote(paymentNote);
    }

    BranchAdapter getFinancialInstitutionBranch() {
        return this.financialAccount.getFinancialInstitutionBranch();
    }

    void setFinancialInstitutionBranch(BranchAdapter value) {
        this.financialAccount.setFinancialInstitutionBranch(value);
    }

    CountryAdapter getCountry() {
        return this.financialAccount.getCountry();
    }

    void setCountry(CountryAdapter value) {
        this.financialAccount.setCountry(value);
    }

    String getId() {
        return this.financialAccount.getId();
    }

    void setId(String value) {
        this.financialAccount.setId(value);
    }

}
