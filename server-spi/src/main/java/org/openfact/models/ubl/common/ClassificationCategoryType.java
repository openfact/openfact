package org.openfact.models.ubl.common;

import java.util.List;

public interface ClassificationCategoryType {

    NameTypeCommBas getName();

    void setName(NameTypeCommBas value);

    CodeValueType getCodeValue();

    void setCodeValue(CodeValueType value);

    List<DescriptionType> getDescription();

    void setDescription(List<DescriptionType> description);

    List<ClassificationCategoryType> getCategorizesClassificationCategory();

    void setCategorizesClassificationCategory();

    String getId();

    void setId(String value);

}
