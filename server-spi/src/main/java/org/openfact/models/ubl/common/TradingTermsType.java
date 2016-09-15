package org.openfact.models.ubl.common;

import java.util.List;

public interface TradingTermsType {

    List<InformationType> getInformation();

    void setInformation(List<InformationType> information);

    ReferenceType getReference();

    void setReference(ReferenceType value);

    AddressType getApplicableAddress();

    void setApplicableAddress(AddressType value);

    String getId();

    void setId(String value);

}
