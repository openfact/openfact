package org.openfact.models.ubl.common;

import java.util.List;

public interface ClassificationSchemeModel {

    IDModel getID();

    void setID(IDModel value);

    UUIDModel getUUID();

    void setUUID(UUIDModel value);

    LastRevisionDateModel getLastRevisionDate();

    void setLastRevisionDate(LastRevisionDateModel value);

    LastRevisionTimeModel getLastRevisionTime();

    void setLastRevisionTime(LastRevisionTimeModel value);

    NoteModel getNote();

    void setNote(NoteModel value);

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    AgencyIDModel getAgencyID();

    void setAgencyID(AgencyIDModel value);

    AgencyNameModel getAgencyName();

    void setAgencyName(AgencyNameModel value);

    VersionIDModel getVersionID();

    void setVersionID(VersionIDModel value);

    URIModel getURI();

    void setURI(URIModel value);

    SchemeURIModel getSchemeURI();

    void setSchemeURI(SchemeURIModel value);

    LanguageIDModel getLanguageID();

    void setLanguageID(LanguageIDModel value);

    List<ClassificationCategoryModel> getClassificationCategory();

    void setClassificationCategory(List<ClassificationCategoryModel> classificationCategory);

    String getId();

    void setId(String value);

}
