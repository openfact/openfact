//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "DOCUMENTREFERENCE")
public class DocumentReferenceEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID_UBL")
    protected String ID;

    @Column(name = "COPY_INDICATOR")
    @Type(type = "numeric_boolean")
    protected boolean copyIndicator;

    @Column(name = "UUID")
    protected String uuid;

    @Column(name = "ISSUE_DATE")
    @Type(type = "LocalDate, java.time.LocalDate")
    protected LocalDate issueDate;

    @Column(name = "DOCUMENT_CODE")
    protected String documentCode;

    @Column(name = "DOCUMENT")
    protected String document;

    @ElementCollection
    @Column(name = "VALUE")
    @CollectionTable(name = "DOCUMENTREFERENCE_XPATH", joinColumns = {
            @JoinColumn(name = "DOCUMENTREFERENCE_ID") })
    protected List<String> xPath = new ArrayList<>();

    @ManyToOne(targetEntity = AttachmentEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "ATTACHMENT_DOCUMENTREFERENCE")
    protected AttachmentEntity attachment = new AttachmentEntity();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the iD
     */
    public String getID() {
        return ID;
    }

    /**
     * @param iD
     *            the iD to set
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * @return the copyIndicator
     */
    public boolean isCopyIndicator() {
        return copyIndicator;
    }

    /**
     * @param copyIndicator
     *            the copyIndicator to set
     */
    public void setCopyIndicator(boolean copyIndicator) {
        this.copyIndicator = copyIndicator;
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     *            the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * @return the issueDate
     */
    public LocalDate getIssueDate() {
        return issueDate;
    }

    /**
     * @param issueDate
     *            the issueDate to set
     */
    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * @return the documentCode
     */
    public String getDocumentCode() {
        return documentCode;
    }

    /**
     * @param documentCode
     *            the documentCode to set
     */
    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }

    /**
     * @return the document
     */
    public String getDocument() {
        return document;
    }

    /**
     * @param document
     *            the document to set
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * @return the xPath
     */
    public List<String> getxPath() {
        return xPath;
    }

    /**
     * @param xPath
     *            the xPath to set
     */
    public void setxPath(List<String> xPath) {
        this.xPath = xPath;
    }

    /**
     * @return the attachment
     */
    public AttachmentEntity getAttachment() {
        return attachment;
    }

    /**
     * @param attachment
     *            the attachment to set
     */
    public void setAttachment(AttachmentEntity attachment) {
        this.attachment = attachment;
    }

}
