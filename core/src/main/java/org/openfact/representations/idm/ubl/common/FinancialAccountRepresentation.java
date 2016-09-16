package org.openfact.representations.idm.ubl.common;

import java.util.List;

public class FinancialAccountRepresentation {
    private String ID;
    private String name;
    private String accountRepresentationCode;
    private String currencyCode;
    private List<String> paymentNote;
    private BranchRepresentation financialInstitutionBranch;
    private CountryRepresentation country;
    private String id;

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BranchRepresentation getFinancialInstitutionBranch() {
        return this.financialInstitutionBranch;
    }

    public void setFinancialInstitutionBranch(BranchRepresentation financialInstitutionBranch) {
        this.financialInstitutionBranch = financialInstitutionBranch;
    }

    public CountryRepresentation getCountry() {
        return this.country;
    }

    public void setCountry(CountryRepresentation country) {
        this.country = country;
    }

    public String getAccountRepresentationCode() {
        return this.accountRepresentationCode;
    }

    public void setAccountRepresentationCode(String accountRepresentationCode) {
        this.accountRepresentationCode = accountRepresentationCode;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPaymentNote() {
        return this.paymentNote;
    }

    public void setPaymentNote(List<String> paymentNote) {
        this.paymentNote = paymentNote;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}