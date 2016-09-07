package org.openfact.models.jpa.entities.ubl;

/**
 * A class to describe a supplier party.
 * 
 * @author Erik
 * @version 2.0
 * @created 07-Set.-2016 9:18:00 a. m.
 */
public class SupplierParty {

    /**
     * An additional identifier for this supplier party.
     */
    private String additionalAccountID;
    /**
     * An identifier for this supplier party, assigned by the customer.
     */
    private String customerAssignedAccountID;
    /**
     * Text describing the supplier's ability to send invoice data via a
     * purchase card provider (e.g., VISA, MasterCard, American Express).
     */
    private String dataSendingCapability;
    private Contact sellerContact;
    private Contact accountingContact;
    private Contact despatchContact;
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
     * @return the dataSendingCapability
     */
    public String getDataSendingCapability() {
        return dataSendingCapability;
    }

    /**
     * @param dataSendingCapability
     *            the dataSendingCapability to set
     */
    public void setDataSendingCapability(String dataSendingCapability) {
        this.dataSendingCapability = dataSendingCapability;
    }

    /**
     * @return the sellerContact
     */
    public Contact getSellerContact() {
        return sellerContact;
    }

    /**
     * @param sellerContact
     *            the sellerContact to set
     */
    public void setSellerContact(Contact sellerContact) {
        this.sellerContact = sellerContact;
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
     * @return the despatchContact
     */
    public Contact getDespatchContact() {
        return despatchContact;
    }

    /**
     * @param despatchContact
     *            the despatchContact to set
     */
    public void setDespatchContact(Contact despatchContact) {
        this.despatchContact = despatchContact;
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