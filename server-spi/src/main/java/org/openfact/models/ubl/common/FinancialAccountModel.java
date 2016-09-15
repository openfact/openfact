package org.openfact.models.ubl.common;

import java.util.List;

public interface FinancialAccountModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    String getAccountModelCode();

    void setAccountModelCode(String value);

    String getCurrencyCode();

    void setCurrencyCode(String value);

    List<PaymentNoteModel> getPaymentNote();

    void setPaymentNote(List<PaymentNoteModel> paymentNote);

    BranchModel getFinancialInstitutionBranch();

    void setFinancialInstitutionBranch(BranchModel value);

    CountryModel getCountry();

    void setCountry(CountryModel value);

    String getId();

    void setId(String value);

}
