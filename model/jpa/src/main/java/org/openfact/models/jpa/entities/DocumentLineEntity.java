package org.openfact.models.jpa.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "DOCUMENT_LINE")
@NamedQueries(value = {
        @NamedQuery(name = "deleteDocumentLinesByOrganization", query = "delete from DocumentLineEntity l where l.document IN (select doc from DocumentEntity doc where doc.organizationId=:organizationId)")
})
public class DocumentLineEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_ID")
    private DocumentEntity document;

    @OneToMany(cascade = {CascadeType.REMOVE}, orphanRemoval = true, mappedBy = "documentLine")
    private Collection<DocumentLineAttributeEntity> attributes = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity document) {
        this.document = document;
    }

    public Collection<DocumentLineAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<DocumentLineAttributeEntity> attributes) {
        this.attributes = attributes;
    }
}
