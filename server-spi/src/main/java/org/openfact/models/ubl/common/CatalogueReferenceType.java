package org.openfact.models.ubl.common;

import java.util.List;

public interface CatalogueReferenceType {

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    IssueDateType getIssueDate();

    void setIssueDate(IssueDateType value);

    IssueTimeType getIssueTime();

    void setIssueTime(IssueTimeType value);

    RevisionDateType getRevisionDate();

    void setRevisionDate(RevisionDateType value);

    RevisionTimeType getRevisionTime();

    void setRevisionTime(RevisionTimeType value);

    List<NoteType> getNote();

    void setNote(List<NoteType> note);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    VersionIDType getVersionID();

    void setVersionID(VersionIDType value);

    PreviousVersionIDType getPreviousVersionID();

    void setPreviousVersionID(PreviousVersionIDType value);

    String getId();

    void setId(String value);

}
