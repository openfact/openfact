package org.openfact.models.ubl.common;

import java.util.List;

public interface PriceListModel {

    String getID();

    void setID(String value);

    String getStatusCode();

    void setStatusCode(String value);

    List<PeriodModel> getValidityPeriod();

    void setValidityPeriod(List<PeriodModel> validityPeriod);

    PriceListModel getPreviousPriceList();

    void setPreviousPriceList(PriceListModel value);

    String getId();

    

}
