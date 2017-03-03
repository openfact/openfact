package org.openfact.models.jpa;

import org.jboss.logging.Logger;
import org.openfact.models.DocumentLineModel;
import org.openfact.models.DocumentModel;
import org.openfact.models.jpa.entities.DocumentLineAttributeEntity;
import org.openfact.models.jpa.entities.DocumentLineEntity;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DocumentLineAdapter implements DocumentLineModel, JpaModel<DocumentLineEntity> {

    protected static final Logger logger = Logger.getLogger(DocumentLineAdapter.class);

    protected DocumentModel document;
    protected DocumentLineEntity line;
    protected EntityManager em;

    public DocumentLineAdapter(DocumentModel document, EntityManager em, DocumentLineEntity line) {
        this.document = document;
        this.em = em;
        this.line = line;
    }

    @Override
    public DocumentLineEntity getEntity() {
        return line;
    }

    @Override
    public String getId() {
        return line.getId();
    }

    @Override
    public void setAttribute(String name, String value) {
        for (DocumentLineAttributeEntity attr : line.getAttributes()) {
            if (attr.getName().equals(name)) {
                attr.setValue(value);
                return;
            }
        }
        DocumentLineAttributeEntity attr = new DocumentLineAttributeEntity();
        attr.setName(name);
        attr.setValue(value);
        attr.setDocumentLine(line);
        em.persist(attr);
        line.getAttributes().add(attr);
    }

    @Override
    public void setAttribute(String name, Boolean value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Integer value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, Long value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void setAttribute(String name, BigDecimal value) {
        setAttribute(name, value.toString());
    }

    @Override
    public void removeAttribute(String name) {
        Iterator<DocumentLineAttributeEntity> it = line.getAttributes().iterator();
        while (it.hasNext()) {
            DocumentLineAttributeEntity attr = it.next();
            if (attr.getName().equals(name)) {
                it.remove();
                em.remove(attr);
            }
        }
    }

    @Override
    public String getAttribute(String name) {
        for (DocumentLineAttributeEntity attr : line.getAttributes()) {
            if (attr.getName().equals(name)) {
                return attr.getValue();
            }
        }
        return null;
    }

    @Override
    public Integer getAttribute(String name, Integer defaultValue) {
        String v = getAttribute(name);
        return v != null ? Integer.parseInt(v) : defaultValue;

    }

    @Override
    public Long getAttribute(String name, Long defaultValue) {
        String v = getAttribute(name);
        return v != null ? Long.parseLong(v) : defaultValue;

    }

    @Override
    public Boolean getAttribute(String name, Boolean defaultValue) {
        String v = getAttribute(name);
        return v != null ? Boolean.parseBoolean(v) : defaultValue;

    }

    @Override
    public Map<String, String> getAttributes() {
        // should always return a copy
        Map<String, String> result = new HashMap<String, String>();
        for (DocumentLineAttributeEntity attr : line.getAttributes()) {
            result.put(attr.getName(), attr.getValue());
        }
        return result;
    }

}
