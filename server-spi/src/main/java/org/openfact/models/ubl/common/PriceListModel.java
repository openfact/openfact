package org.openfact.models.ubl.common;

import java.util.List;

public interface PriceListModel {

    IDModel getID();

    void setID(IDModel value);

    StatusCodeModel getStatusCode();

    void setStatusCode(StatusCodeModel value);

    List<PeriodModel> getValidityPeriod();

    void setValidityPeriod(List<PeriodModel> validityPeriod);

    PriceListModel getPreviousPriceList();

    void setPreviousPriceList(PriceListModel value);

    String getId();

    void setId(String value);

}
