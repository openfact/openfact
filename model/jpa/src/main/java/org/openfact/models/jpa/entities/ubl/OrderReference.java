package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A class to define a reference to an Order.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:16:18 a. m.
 */
public class OrderReference {

    /**
     * Indicates whether the referenced Order is a copy (true) or the original
     * (false).
     */
    private boolean copyIndicator;
    /**
     * Text used for tagging purchasing card transactions.
     */
    private String customerReference;
    /**
     * An identifier for this order reference, assigned by the buyer.
     */
    private String ID;
    /**
     * The date on which the referenced Order was issued.
     */
    private LocalDate issueDate;
    /**
     * The time at which the referenced Order was issued.
     */
    private LocalTime issueTime;
    /**
     * A code signifying the type of the referenced Order.
     */
    private String orderTypeCode;
    /**
     * An identifier for this order reference, assigned by the seller.
     */
    private String salesOrderID;
    /**
     * A universally unique identifier for this order reference.
     */
    private String UUID;
    private DocumentReference m_DocumentReference;

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
     * @return the orderTypeCode
     */
    public String getOrderTypeCode() {
        return orderTypeCode;
    }

    /**
     * @param orderTypeCode
     *            the orderTypeCode to set
     */
    public void setOrderTypeCode(String orderTypeCode) {
        this.orderTypeCode = orderTypeCode;
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
     * @return the uUID
     */
    public String getUUID() {
        return UUID;
    }

    /**
     * @param uUID
     *            the uUID to set
     */
    public void setUUID(String uUID) {
        UUID = uUID;
    }

    /**
     * @return the m_DocumentReference
     */
    public DocumentReference getM_DocumentReference() {
        return m_DocumentReference;
    }

    /**
     * @param m_DocumentReference
     *            the m_DocumentReference to set
     */
    public void setM_DocumentReference(DocumentReference m_DocumentReference) {
        this.m_DocumentReference = m_DocumentReference;
    }

}