package org.openfact.models.ubl.common;

import java.util.List;

public interface ResponseModel {

    ReferenceIDModel getReferenceID();

    void setReferenceID(ReferenceIDModel value);

    ResponseCodeModel getResponseCode();

    void setResponseCode(ResponseCodeModel value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    String getId();

    void setId(String value);

}
