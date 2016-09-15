package org.openfact.models.ubl.common;

import java.util.List;

public interface LineResponseType {

    LineReferenceType getLineReference();

    void setLineReference(LineReferenceType value);

    List<ResponseType> getResponse();

    void setResponse(List<ResponseType> response);

    String getId();

    void setId(String value);

}
