package org.openfact.models.ubl.common;

import java.util.List;

public interface ClassificationCategoryModel {

    String getName();

    void setName(String value);

    String getCodeValue();

    void setCodeValue(String value);

    List<String> getDescription();

    void setDescription(List<String> description);

    List<ClassificationCategoryModel> getCategorizesClassificationCategory();

    void setCategorizesClassificationCategory();

    String getId();

    void setId(String value);

}
