package org.openfact.models.jpa.ubl.common;

import java.util.List;

import javax.persistence.EntityManager;

import org.openfact.models.OpenfactSession;
import org.jboss.logging.Logger;
import org.openfact.models.jpa.JpaModel;
import org.openfact.models.ubl.common.BranchModel;
import org.openfact.models.ubl.common.CountryModel;
import org.openfact.models.ubl.common.FinancialAccountModel;

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

    @Override
    public String getID() {
        return this.financialAccount.getID();
    }

    @Override
    public void setID(String value) {
        this.financialAccount.setID(value);
    }

    @Override
    public String getName() {
        return this.financialAccount.getName();
    }

    @Override
    public void setName(String value) {
        this.financialAccount.setName(value);
    }

    @Override
    public String getAccountModelCode() {
        return this.financialAccount.getAccountModelCode();
    }

    @Override
    public void setAccountAdapterCode(String value) {
        this.financialAccount.setAccountAdapterCode(value);
    }

    @Override
    public String getCurrencyCode() {
        return this.financialAccount.getCurrencyCode();
    }

    @Override
    public void setCurrencyCode(String value) {
        this.financialAccount.setCurrencyCode(value);
    }

    @Override
    public List<String> getPaymentNote() {
        return this.financialAccount.getPaymentNote();
    }

    @Override
    public void setPaymentNote(List<String> paymentNote) {
        this.financialAccount.setPaymentNote(paymentNote);
    }

    @Override
    public BranchModel getFinancialInstitutionBranch() {
        return this.financialAccount.getFinancialInstitutionBranch();
    }

    @Override
    public void setFinancialInstitutionBranch(BranchAdapter value) {
        this.financialAccount.setFinancialInstitutionBranch(value);
    }

    @Override
    public CountryModel getCountry() {
        return this.financialAccount.getCountry();
    }

    @Override
    public void setCountry(CountryAdapter value) {
        this.financialAccount.setCountry(value);
    }

    @Override
    public String getId() {
        return this.financialAccount.getId();
    }

    @Override
    public void setId(String value) {
        this.financialAccount.setId(value);
    }

}
