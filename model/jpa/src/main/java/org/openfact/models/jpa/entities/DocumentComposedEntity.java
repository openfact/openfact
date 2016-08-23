package org.openfact.models.jpa.entities;

import java.util.ArrayList;
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
public class DocumentComposedEntity extends DocumentComponentEntity {

    @OneToMany(mappedBy = "documentParent", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<DocumentComponentEntity> childrens = new ArrayList<>();

    @Override
    public void add(DocumentComponentEntity document) {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(DocumentComponentEntity document) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeById(String documentId) {
        // TODO Auto-generated method stub

    }

    @Override
    public void removeByname(String documentname) {
        // TODO Auto-generated method stub

    }

    @Override
    public DocumentComponentEntity getChildById(String documentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DocumentComponentEntity getChildByName(String documentName) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DocumentComponentEntity getParent() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<DocumentComponentEntity> getChildrens() {
        // TODO Auto-generated method stub
        return null;
    }

}
