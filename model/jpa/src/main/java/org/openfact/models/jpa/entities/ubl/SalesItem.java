package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe information related to an item in a sales context
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:17:37 a. m.
 */
public class SalesItem {

    /**
     * The quantity the given information are related to
     */
    private BigDecimal Quantity;
    private List<ActivityProperty> activityProperties = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private Price TaxExclusivePrice;
    private Price TaxInclusivePrice;

    public SalesItem() {

    }

    /**
     * @return the quantity
     */
    public BigDecimal getQuantity() {
        return Quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(BigDecimal quantity) {
        Quantity = quantity;
    }

    /**
     * @return the activityProperties
     */
    public List<ActivityProperty> getActivityProperties() {
        return activityProperties;
    }

    /**
     * @param activityProperties
     *            the activityProperties to set
     */
    public void setActivityProperties(List<ActivityProperty> activityProperties) {
        this.activityProperties = activityProperties;
    }

    /**
     * @return the items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * @param items
     *            the items to set
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * @return the taxExclusivePrice
     */
    public Price getTaxExclusivePrice() {
        return TaxExclusivePrice;
    }

    /**
     * @param taxExclusivePrice
     *            the taxExclusivePrice to set
     */
    public void setTaxExclusivePrice(Price taxExclusivePrice) {
        TaxExclusivePrice = taxExclusivePrice;
    }

    /**
     * @return the taxInclusivePrice
     */
    public Price getTaxInclusivePrice() {
        return TaxInclusivePrice;
    }

    /**
     * @param taxInclusivePrice
     *            the taxInclusivePrice to set
     */
    public void setTaxInclusivePrice(Price taxInclusivePrice) {
        TaxInclusivePrice = taxInclusivePrice;
    }

}// end Sales Item