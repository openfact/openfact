package org.openfact.models.jpa.entities;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.openfact.models.ModelException;
import org.openfact.models.enums.DocumentType;

/**
 * @author carlosthe19916@sistcoop.com
 */

@Entity
@Table(name = "DOCUMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DOCUMENT_TYPE")
public abstract class DocumentEntity {

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = "ID", length = 36)
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    protected String id;

    @NotNull
    @Column(name = "NAME")
    protected String name;

    @NotNull
    @Column(name = "DOCUMENT_ID")
    protected String documentId;

    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "CODE")
    protected String code;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    protected DocumentType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_PARENT_ID")
    protected DocumentEntity parent;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "ORGANIZATION_ID")
    protected OrganizationEntity organization;

    public void add(DocumentEntity document) {
        throw new ModelException("Current operation is not support for this object");
    }

    public boolean remove(DocumentEntity document) {
        throw new ModelException("Current operation is not support for this object");
    }

    public boolean removeByDocumentId(String documentId) {
        throw new ModelException("Current operation is not support for this object");
    }

    public boolean removeByname(String documentname) {
        throw new ModelException("Current operation is not support for this object");
    }

    public DocumentEntity getChildByDocumentId(String documentId) {
        throw new ModelException("Current operation is not support for this object");
    }

    public DocumentEntity getChildByName(String documentName) {
        throw new ModelException("Current operation is not support for this object");
    }

    public DocumentEntity getParent() {
        throw new ModelException("Current operation is not support for this object");
    }

    public List<DocumentEntity> getChildrens() {
        throw new ModelException("Current operation is not support for this object");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public void setParent(DocumentEntity parent) {
        this.parent = parent;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DocumentEntity other = (DocumentEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
