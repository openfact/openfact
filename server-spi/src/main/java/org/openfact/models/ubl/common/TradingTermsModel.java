package org.openfact.models.ubl.common;

import java.util.List;

public interface TradingTermsModel {

    List<String> getInformation();

    void setInformation(List<String> information);

    String getReference();

    void setReference(String value);

    AddressModel getApplicableAddress();

    void setApplicableAddress(AddressModel value);

    String getId();

    void setId(String value);

}
