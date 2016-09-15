package org.openfact.models.ubl.common;

import java.util.List;

public interface TradingTermsModel {

    List<InformationModel> getInformation();

    void setInformation(List<InformationModel> information);

    ReferenceModel getReference();

    void setReference(ReferenceModel value);

    AddressModel getApplicableAddress();

    void setApplicableAddress(AddressModel value);

    String getId();

    void setId(String value);

}
