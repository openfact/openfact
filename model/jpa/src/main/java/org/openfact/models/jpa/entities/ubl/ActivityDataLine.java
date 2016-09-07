package org.openfact.models.jpa.entities.ubl;

/**
 * A class to associate a time period and locations (activity data) with an item
 * for inventory planning purposes.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:12:32 a. m.
 */
public class ActivityDataLine {

    /**
     * An identifier for this activity data line.
     */
    private String ID;

    /**
     * A code signifying the type of supply chain activity.
     */
    private String supplyChainActivityTypeCode;
    private CustomerParty buyerCustomerParty;
    private Location activityOriginLocation;
    private Period activityPeriod;
    private Location activityFinalLocation;
    private SalesItem m_SalesItem;
    private SupplierParty sellerSupplierParty;

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
     * @return the supplyChainActivityTypeCode
     */
    public String getSupplyChainActivityTypeCode() {
        return supplyChainActivityTypeCode;
    }

    /**
     * @param supplyChainActivityTypeCode
     *            the supplyChainActivityTypeCode to set
     */
    public void setSupplyChainActivityTypeCode(String supplyChainActivityTypeCode) {
        this.supplyChainActivityTypeCode = supplyChainActivityTypeCode;
    }

    /**
     * @return the buyerCustomerParty
     */
    public CustomerParty getBuyerCustomerParty() {
        return buyerCustomerParty;
    }

    /**
     * @param buyerCustomerParty
     *            the buyerCustomerParty to set
     */
    public void setBuyerCustomerParty(CustomerParty buyerCustomerParty) {
        this.buyerCustomerParty = buyerCustomerParty;
    }

    /**
     * @return the activityOriginLocation
     */
    public Location getActivityOriginLocation() {
        return activityOriginLocation;
    }

    /**
     * @param activityOriginLocation
     *            the activityOriginLocation to set
     */
    public void setActivityOriginLocation(Location activityOriginLocation) {
        this.activityOriginLocation = activityOriginLocation;
    }

    /**
     * @return the activityPeriod
     */
    public Period getActivityPeriod() {
        return activityPeriod;
    }

    /**
     * @param activityPeriod
     *            the activityPeriod to set
     */
    public void setActivityPeriod(Period activityPeriod) {
        this.activityPeriod = activityPeriod;
    }

    /**
     * @return the activityFinalLocation
     */
    public Location getActivityFinalLocation() {
        return activityFinalLocation;
    }

    /**
     * @param activityFinalLocation
     *            the activityFinalLocation to set
     */
    public void setActivityFinalLocation(Location activityFinalLocation) {
        this.activityFinalLocation = activityFinalLocation;
    }

    /**
     * @return the m_SalesItem
     */
    public SalesItem getM_SalesItem() {
        return m_SalesItem;
    }

    /**
     * @param m_SalesItem
     *            the m_SalesItem to set
     */
    public void setM_SalesItem(SalesItem m_SalesItem) {
        this.m_SalesItem = m_SalesItem;
    }

    /**
     * @return the sellerSupplierParty
     */
    public SupplierParty getSellerSupplierParty() {
        return sellerSupplierParty;
    }

    /**
     * @param sellerSupplierParty
     *            the sellerSupplierParty to set
     */
    public void setSellerSupplierParty(SupplierParty sellerSupplierParty) {
        this.sellerSupplierParty = sellerSupplierParty;
    }

}