package org.openfact.models.ubl.common;

import java.util.List;

public interface FinancialAccountType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    AccountTypeCodeType getAccountTypeCode();

    void setAccountTypeCode(AccountTypeCodeType value);

    CurrencyCodeTypeCommBas getCurrencyCode();

    void setCurrencyCode(CurrencyCodeTypeCommBas value);

    List<PaymentNoteType> getPaymentNote();

    void setPaymentNote(List<PaymentNoteType> paymentNote);

    BranchType getFinancialInstitutionBranch();

    void setFinancialInstitutionBranch(BranchType value);

    CountryType getCountry();

    void setCountry(CountryType value);

    String getId();

    void setId(String value);

}
