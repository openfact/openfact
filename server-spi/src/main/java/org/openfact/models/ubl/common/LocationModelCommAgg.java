package org.openfact.models.ubl.common;

import java.util.List;

public interface LocationModelCommAgg {

    String getID();

    void setID(String value);

    String getDescription();

    void setDescription(String value);

    String getConditions();

    void setConditions(String value);

    String getCountrySubentity();

    void setCountrySubentity(String value);

    String getCountrySubentityCode();

    void setCountrySubentityCode(String value);

    List<PeriodModel> getValidityPeriod();

    void setValidityPeriod(List<PeriodModel> validityPeriod);

    AddressModel getAddress();

    void setAddress(AddressModel value);

    String getId();

    void setId(String value);

}
