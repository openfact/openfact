package org.openfact.models.ubl.common;

import java.util.List;

public interface ClassificationCategoryModel {

    NameModelCommBas getName();

    void setName(NameModelCommBas value);

    CodeValueModel getCodeValue();

    void setCodeValue(CodeValueModel value);

    List<DescriptionModel> getDescription();

    void setDescription(List<DescriptionModel> description);

    List<ClassificationCategoryModel> getCategorizesClassificationCategory();

    void setCategorizesClassificationCategory();

    String getId();

    void setId(String value);

}
