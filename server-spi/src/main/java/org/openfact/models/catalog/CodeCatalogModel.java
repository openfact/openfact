package org.openfact.models.catalog;

import java.util.Map;

public interface CodeCatalogModel {

    String getId();

    String getType();

    void setType(String type);

    String getCode();

    void setCode(String code);

    String getDescription();

    void setDescription(String description);

    String getLocale();

    void setLocale(String locale);

    Map<String, String> getAttributes();

    void setAttributes(Map<String, String> attributes);

}
