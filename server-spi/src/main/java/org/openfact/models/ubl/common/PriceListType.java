package org.openfact.models.ubl.common;

import java.util.List;

public interface PriceListType {

    IDType getID();

    void setID(IDType value);

    StatusCodeType getStatusCode();

    void setStatusCode(StatusCodeType value);

    List<PeriodType> getValidityPeriod();

    void setValidityPeriod(List<PeriodType> validityPeriod);

    PriceListType getPreviousPriceList();

    void setPreviousPriceList(PriceListType value);

    String getId();

    void setId(String value);

}
