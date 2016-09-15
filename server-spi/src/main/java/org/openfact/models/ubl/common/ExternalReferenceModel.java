package org.openfact.models.ubl.common;

public interface ExternalReferenceModel {

    URIModel getURI();

    void setURI(URIModel value);

    DocumentHashModel getDocumentHash();

    void setDocumentHash(DocumentHashModel value);

    ExpiryDateModel getExpiryDate();

    void setExpiryDate(ExpiryDateModel value);

    ExpiryTimeModel getExpiryTime();

    void setExpiryTime(ExpiryTimeModel value);

    String getId();

    void setId(String value);

}
