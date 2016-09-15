package org.openfact.models.ubl.common;

import java.util.List;

public interface CatalogueReferenceModel {

    IDModel getID();

    void setID(IDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    IssueDateModel getIssueDate();

    void setIssueDate(IssueDateModel value);

    IssueTimeModel getIssueTime();

    void setIssueTime(IssueTimeModel value);

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
