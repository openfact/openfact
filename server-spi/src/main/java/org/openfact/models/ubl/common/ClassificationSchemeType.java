package org.openfact.models.ubl.common;

import java.util.List;

public interface ClassificationSchemeType {

    IDType getID();

    void setID(IDType value);

    UUIDType getUUID();

    void setUUID(UUIDType value);

    LastRevisionDateType getLastRevisionDate();

    void setLastRevisionDate(LastRevisionDateType value);

    LastRevisionTimeType getLastRevisionTime();

    void setLastRevisionTime(LastRevisionTimeType value);

    NoteType getNote();

    void setNote(NoteType value);

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    AgencyIDType getAgencyID();

    void setAgencyID(AgencyIDType value);

    AgencyNameType getAgencyName();

    void setAgencyName(AgencyNameType value);

    VersionIDType getVersionID();

    void setVersionID(VersionIDType value);

    URIType getURI();

    void setURI(URIType value);

    SchemeURIType getSchemeURI();

    void setSchemeURI(SchemeURIType value);

    LanguageIDType getLanguageID();

    void setLanguageID(LanguageIDType value);

    List<ClassificationCategoryType> getClassificationCategory();

    void setClassificationCategory(List<ClassificationCategoryType> classificationCategory);

    String getId();

    void setId(String value);

}
