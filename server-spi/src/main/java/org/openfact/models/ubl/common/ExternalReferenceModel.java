package org.openfact.models.ubl.common;

public interface ExternalReferenceModel {

    String getURI();

    void setURI(String value);

    String getDocumentHash();

    void setDocumentHash(String value);

    ExpiryDateModel getExpiryDate();

    void setExpiryDate(ExpiryDateModel value);

    ExpiryTimeModel getExpiryTime();

    void setExpiryTime(ExpiryTimeModel value);

    String getId();

    void setId(String value);

}
