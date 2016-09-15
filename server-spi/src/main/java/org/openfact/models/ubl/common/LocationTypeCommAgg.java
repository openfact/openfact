package org.openfact.models.ubl.common;

import java.util.List;

public interface LocationTypeCommAgg {

    IDType getID();

    void setID(IDType value);

    DescriptionType getDescription();

    void setDescription(DescriptionType value);

    ConditionsType getConditions();

    void setConditions(ConditionsType value);

    CountrySubentityType getCountrySubentity();

    void setCountrySubentity(CountrySubentityType value);

    CountrySubentityCodeType getCountrySubentityCode();

    void setCountrySubentityCode(CountrySubentityCodeType value);

    List<PeriodType> getValidityPeriod();

    void setValidityPeriod(List<PeriodType> validityPeriod);

    AddressType getAddress();

    void setAddress(AddressType value);

    String getId();

    void setId(String value);

}
