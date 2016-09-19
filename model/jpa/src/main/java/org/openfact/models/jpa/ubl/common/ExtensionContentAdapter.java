package org.openfact.models.jpa.ubl.common;

import org.w3c.dom.Element;

public class ExtensionContentAdapter implements ExtensionContentModel, JpaModel<ExtensionContentEntity> {

    protected static final Logger logger = Logger.getLogger(ExtensionContentAdapter.class);
    protected ExtensionContentEntity extensionContent;
    protected EntityManager em;
    protected OpenfactSession session;

    public ExtensionContentAdapter(OpenfactSession session, EntityManager em,
            ExtensionContentEntity extensionContent) {
        this.session = session;
        this.em = em;
        this.extensionContent = extensionContent;
    }

    Element getAny() {
        return this.extensionContent.getAny();
    }

    void setAny(Element value) {
        this.extensionContent.setAny(value);
    }

    String getId() {
        return this.extensionContent.getId();
    }

    void setId(String value) {
        this.extensionContent.setId(value);
    }

    String getAnyItem() {
        return this.extensionContent.getAnyItem();
    }

    void setAnyItem(String target) {
        this.extensionContent.setAnyItem(target);
    }

}
