package org.openfact.models.ubl.common;

import java.util.List;

public interface ResponseModel {

    String getReferenceID();

    void setReferenceID(String value);

    String getResponseCode();

    void setResponseCode(String value);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getId();

    void setId(String value);

}
