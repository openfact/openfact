package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a customer party.
 * 
 * @author Erik
 * @version 1.0
 * @created 07-Set.-2016 9:14:16 a. m.
 */
public class CustomerParty {

    /**
     * An identifier for the customer's account, assigned by a third party.
     */
    private String additionalAccountID;
    /**
     * An identifier for the customer's account, assigned by the customer
     * itself.
     */
    private String customerAssignedAccountID;
    /**
     * An identifier for the customer's account, assigned by the supplier.
     */
    private String supplierAssignedAccountID;
    private Contact deliveryContact;
    private Contact accountingContact;
    private Contact buyerContact;
    private Party m_Party;

    /**
     * @return the additionalAccountID
     */
    public String getAdditionalAccountID() {
        return additionalAccountID;
    }

    /**
     * @param additionalAccountID
     *            the additionalAccountID to set
     */
    public void setAdditionalAccountID(String additionalAccountID) {
        this.additionalAccountID = additionalAccountID;
    }

    /**
     * @return the customerAssignedAccountID
     */
    public String getCustomerAssignedAccountID() {
        return customerAssignedAccountID;
    }

    /**
     * @param customerAssignedAccountID
     *            the customerAssignedAccountID to set
     */
    public void setCustomerAssignedAccountID(String customerAssignedAccountID) {
        this.customerAssignedAccountID = customerAssignedAccountID;
    }

    /**
     * @return the supplierAssignedAccountID
     */
    public String getSupplierAssignedAccountID() {
        return supplierAssignedAccountID;
    }

    /**
     * @param supplierAssignedAccountID
     *            the supplierAssignedAccountID to set
     */
    public void setSupplierAssignedAccountID(String supplierAssignedAccountID) {
        this.supplierAssignedAccountID = supplierAssignedAccountID;
    }

    /**
     * @return the deliveryContact
     */
    public Contact getDeliveryContact() {
        return deliveryContact;
    }

    /**
     * @param deliveryContact
     *            the deliveryContact to set
     */
    public void setDeliveryContact(Contact deliveryContact) {
        this.deliveryContact = deliveryContact;
    }

    /**
     * @return the accountingContact
     */
    public Contact getAccountingContact() {
        return accountingContact;
    }

    /**
     * @param accountingContact
     *            the accountingContact to set
     */
    public void setAccountingContact(Contact accountingContact) {
        this.accountingContact = accountingContact;
    }

    /**
     * @return the buyerContact
     */
    public Contact getBuyerContact() {
        return buyerContact;
    }

    /**
     * @param buyerContact
     *            the buyerContact to set
     */
    public void setBuyerContact(Contact buyerContact) {
        this.buyerContact = buyerContact;
    }

    /**
     * @return the m_Party
     */
    public Party getM_Party() {
        return m_Party;
    }

    /**
     * @param m_Party
     *            the m_Party to set
     */
    public void setM_Party(Party m_Party) {
        this.m_Party = m_Party;
    }

}