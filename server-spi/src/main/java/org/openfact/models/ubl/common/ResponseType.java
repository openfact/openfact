package org.openfact.models.ubl.common;

import java.util.List;

public interface ResponseType {

    ReferenceIDType getReferenceID();

    void setReferenceID(ReferenceIDType value);

    ResponseCodeType getResponseCode();

    void setResponseCode(ResponseCodeType value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    String getId();

    void setId(String value);

}
