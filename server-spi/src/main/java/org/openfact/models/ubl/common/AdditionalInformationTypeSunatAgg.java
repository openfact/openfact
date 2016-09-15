package org.openfact.models.ubl.common;

import java.util.List;

public interface AdditionalInformationTypeSunatAgg {

    List<AdditionalMonetaryTotalType> getAdditionalMonetaryTotal();

    void setAdditionalMonetaryTotal(List<AdditionalMonetaryTotalType> additionalMonetaryTotal);

    List<AdditionalPropertyType> getAdditionalProperty();

    void setAdditionalProperty(List<AdditionalPropertyType> additionalProperty);

    String getId();

    void setId(String value);

}
