package org.openfact.models.ubl.common;

public interface BranchModel {

    IDModel getID();

    void setID(IDModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    FinancialInstitutionModel getFinancialInstitution();

    void setFinancialInstitution(FinancialInstitutionModel value);

    AddressModel getAddress();

    void setAddress(AddressModel value);

    String getId();

    void setId(String value);

}
