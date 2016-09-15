package org.openfact.models.ubl.common;

import java.util.List;

public interface AdditionalInformationModelSunatAgg {

    List<AdditionalMonetaryTotalModel> getAdditionalMonetaryTotal();

    void setAdditionalMonetaryTotal(List<AdditionalMonetaryTotalModel> additionalMonetaryTotal);

    List<AdditionalPropertyModel> getAdditionalProperty();

    void setAdditionalProperty(List<AdditionalPropertyModel> additionalProperty);

    String getId();

    void setId(String value);

}
