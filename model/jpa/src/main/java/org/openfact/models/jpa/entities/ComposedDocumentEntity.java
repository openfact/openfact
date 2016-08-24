package org.openfact.models.jpa.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author carlosthe19916@sistcoop.com
 */
@Entity
@DiscriminatorValue(value = "COMPOSED")
public class ComposedDocumentEntity extends DocumentEntity {

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<DocumentEntity> childrens = new ArrayList<>();

    @Override
    public void add(DocumentEntity document) {
        document.setParent(this);
        childrens.add(document);
    }

    @Override
    public boolean remove(DocumentEntity document) {
        if (document == null) {
            return false;
        }

        DocumentEntity documentEntity = null;
        Iterator<DocumentEntity> it = childrens.iterator();
        while (it.hasNext()) {
            DocumentEntity ae = it.next();
            if (ae.equals(document)) {
                documentEntity = ae;
                it.remove();
                break;
            }
        }
        if (documentEntity == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean removeByDocumentId(String documentId) {
        if (documentId == null) {
            return false;
        }

        DocumentEntity documentEntity = null;
        Iterator<DocumentEntity> it = childrens.iterator();
        while (it.hasNext()) {
            DocumentEntity ae = it.next();
            if (ae.getDocumentId().equals(documentId)) {
                documentEntity = ae;
                it.remove();
                break;
            }
        }
        if (documentEntity == null) {
            return false;
        }

        return true;
    }

    @Override
    public boolean removeByname(String documentname) {
        if (documentname == null) {
            return false;
        }

        DocumentEntity documentEntity = null;
        Iterator<DocumentEntity> it = childrens.iterator();
        while (it.hasNext()) {
            DocumentEntity ae = it.next();
            if (ae.getName().equals(documentname)) {
                documentEntity = ae;
                it.remove();
                break;
            }
        }
        if (documentEntity == null) {
            return false;
        }

        return true;
    }

    @Override
    public DocumentEntity getChildByDocumentId(String documentId) {
        return childrens.stream().filter(f -> f.getDocumentId().equals(documentId)).findAny().orElse(null);
    }

    @Override
    public DocumentEntity getChildByName(String documentName) {
        return childrens.stream().filter(f -> f.getName().equals(documentName)).findAny().orElse(null);
    }

    @Override
    public DocumentEntity getParent() {
        return parent;
    }

    @Override
    public List<DocumentEntity> getChildrens() {
        return childrens;
    }

}
