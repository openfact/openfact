package org.openfact.representations.idm.ubl.common;

import org.w3c.dom.Element;

public interface ExtensionContentModel {

    Element getAny();

    void setAny(Element value);

    String getId();

    void setId(String value);

    String getAnyItem();

    void setAnyItem(String target);

}
