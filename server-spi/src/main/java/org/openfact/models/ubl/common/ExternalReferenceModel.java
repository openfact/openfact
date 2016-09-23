package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ExternalReferenceModel {

    String getURI();

    void setURI(String value);

    String getDocumentHash();

    void setDocumentHash(String value);

    LocalDate getExpiryDate();

    void setExpiryDate(LocalDate value);

    LocalTime getExpiryTime();

    void setExpiryTime(LocalTime value);

    String getId();

    void setId(String value);

}
