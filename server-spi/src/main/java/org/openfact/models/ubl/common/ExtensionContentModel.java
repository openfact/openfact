package org.openfact.models.ubl.common;

import org.w3c.dom.Element;

public interface ExtensionContentModel {

    Element getAny();

    void setAny(Element value);

    String getId();

    

    String getAnyItem();

    void setAnyItem(String target);

}
