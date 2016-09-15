package org.openfact.models.ubl.common;

public interface BranchType {

    IDType getID();

    void setID(IDType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    FinancialInstitutionType getFinancialInstitution();

    void setFinancialInstitution(FinancialInstitutionType value);

    AddressType getAddress();

    void setAddress(AddressType value);

    String getId();

    void setId(String value);

}
