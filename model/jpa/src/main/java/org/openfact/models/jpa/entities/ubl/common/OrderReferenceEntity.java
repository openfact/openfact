//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities.ubl.common;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ORDER_REFERENCE")
public class OrderReferenceEntity {

    @Id
    @Column(name = "ID_OFID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    protected String id;

    @Column(name = "ID")
    protected String ID;

    @Column(name = "SALES_ORDER_ID")
    protected String salesOrderID;

    @Column(name = "COPY_INDICATOR")
    protected boolean copyIndicator;

    @Column(name = "UUID")
    protected String uuid;

    @Column(name = "ISSUEDATE")
    protected LocalDate issueDate;

    @Column(name = "ISSUETIME")
    protected LocalTime issueTime;

    @Column(name = "CUSTOMER_REFERENCE")
    protected String customerReference;

    @ManyToOne(targetEntity = DocumentReferenceEntity.class, cascade = { CascadeType.ALL })
    @JoinColumn(name = "DOCUMENTREFERENCE")
    protected DocumentReferenceEntity documentReference = new DocumentReferenceEntity();

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
     * @return the salesOrderID
     */
    public String getSalesOrderID() {
        return salesOrderID;
    }

    /**
     * @param salesOrderID
     *            the salesOrderID to set
     */
    public void setSalesOrderID(String salesOrderID) {
        this.salesOrderID = salesOrderID;
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
     * @return the issueTime
     */
    public LocalTime getIssueTime() {
        return issueTime;
    }

    /**
     * @param issueTime
     *            the issueTime to set
     */
    public void setIssueTime(LocalTime issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * @return the customerReference
     */
    public String getCustomerReference() {
        return customerReference;
    }

    /**
     * @param customerReference
     *            the customerReference to set
     */
    public void setCustomerReference(String customerReference) {
        this.customerReference = customerReference;
    }

    /**
     * @return the documentReference
     */
    public DocumentReferenceEntity getDocumentReference() {
        return documentReference;
    }

    /**
     * @param documentReference
     *            the documentReference to set
     */
    public void setDocumentReference(DocumentReferenceEntity documentReference) {
        this.documentReference = documentReference;
    }

}
