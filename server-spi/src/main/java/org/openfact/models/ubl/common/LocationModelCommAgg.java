package org.openfact.models.ubl.common;

import java.util.List;

public interface LocationModelCommAgg {

    IDModel getID();

    void setID(IDModel value);

    DescriptionModel getDescription();

    void setDescription(DescriptionModel value);

    ConditionsModel getConditions();

    void setConditions(ConditionsModel value);

    CountrySubentityModel getCountrySubentity();

    void setCountrySubentity(CountrySubentityModel value);

    String getCountrySubentityCode();

    void setCountrySubentityCode(String value);

    List<PeriodModel> getValidityPeriod();

    void setValidityPeriod(List<PeriodModel> validityPeriod);

    AddressModel getAddress();

    void setAddress(AddressModel value);

    String getId();

    void setId(String value);

}
