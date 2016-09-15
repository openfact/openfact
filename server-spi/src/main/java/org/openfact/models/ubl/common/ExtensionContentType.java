package org.openfact.models.ubl.common;

import org.w3c.dom.Element;

public interface ExtensionContentType {

    Element getAny();

    void setAny(Element value);

    String getId();

    void setId(String value);

    String getAnyItem();

    void setAnyItem(String target);

}
