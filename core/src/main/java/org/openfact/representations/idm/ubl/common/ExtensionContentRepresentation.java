package org.openfact.representations.idm.ubl.common;

import org.w3c.dom.Element;

public class ExtensionContentRepresentation {
    private Element any;
    private String id;
    private String anyItem;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Element getAny() {
        return this.any;
    }

    public void setAny(Element any) {
        this.any = any;
    }

    public String getAnyItem() {
        return this.anyItem;
    }

    public void setAnyItem(String anyItem) {
        this.anyItem = anyItem;
    }
}