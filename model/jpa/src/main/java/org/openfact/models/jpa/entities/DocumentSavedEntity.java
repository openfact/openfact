package org.openfact.models.jpa.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Embeddable
@Access(AccessType.FIELD)
public class DocumentSavedEntity {

    @NotNull
    @Column(name = "NAME")
    protected String name;

    @NotNull
    @Column(name = "DOCUMENT_ID")
    protected String documentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

}
