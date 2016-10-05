package org.openfact.models.ubl.common;

public interface BranchModel {

    String getID();

    void setID(String value);

    String getName();

    void setName(String value);

    FinancialInstitutionModel getFinancialInstitution();

    void setFinancialInstitution(FinancialInstitutionModel value);

    AddressModel getAddress();

    void setAddress(AddressModel value);

    String getId();

    

}
