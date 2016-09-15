package org.openfact.models.ubl.common;

import java.util.List;

public interface LineResponseModel {

    LineReferenceModel getLineReference();

    void setLineReference(LineReferenceModel value);

    List<ResponseModel> getResponse();

    void setResponse(List<ResponseModel> response);

    String getId();

    void setId(String value);

}
