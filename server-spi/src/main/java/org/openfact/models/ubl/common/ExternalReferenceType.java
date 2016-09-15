package org.openfact.models.ubl.common;

public interface ExternalReferenceType {

    URIType getURI();

    void setURI(URIType value);

    DocumentHashType getDocumentHash();

    void setDocumentHash(DocumentHashType value);

    ExpiryDateType getExpiryDate();

    void setExpiryDate(ExpiryDateType value);

    ExpiryTimeType getExpiryTime();

    void setExpiryTime(ExpiryTimeType value);

    String getId();

    void setId(String value);

}
