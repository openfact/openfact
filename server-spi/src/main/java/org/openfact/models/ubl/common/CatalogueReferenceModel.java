package org.openfact.models.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CatalogueReferenceModel {

    IDModel getID();

    void setID(IDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LocalDate getIssueDate();

    void setIssueDate(LocalDate value);

    LocalTime getIssueTime();

    void setIssueTime(LocalTime value);

    RevisionDateModel getRevisionDate();

    void setRevisionDate(RevisionDateModel value);

    RevisionTimeModel getRevisionTime();

    void setRevisionTime(RevisionTimeModel value);

    List<NoteModel> getNote();

    void setNote(List<NoteModel> note);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    VersionIDModel getVersionID();

    void setVersionID(VersionIDModel value);

    PreviousVersionIDModel getPreviousVersionID();

    void setPreviousVersionID(PreviousVersionIDModel value);

    String getId();

    void setId(String value);

}
