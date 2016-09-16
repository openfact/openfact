package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CatalogueReferenceModel {

    String getID();

    void setID(String value);

    String getUUID();

    void setUUID(String value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    LocalDate getRevisionDate();

    void setRevisionDate(LocalDate value);

    LocalTime getRevisionTime();

    void setRevisionTime(LocalTime value);

    List<String> getNote();

    void setNote(List<String> note);

    List<String> getDescription();

    void setDescription(List<String> description);

    String getVersionID();

    void setVersionID(String value);

    String getPreviousVersionID();

    void setPreviousVersionID(String value);

    String getId();

    void setId(String value);

}
