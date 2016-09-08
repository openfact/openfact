package org.openfact.models.jpa.entities.ubl;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * A class to describe the consumption of a utility product.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:18:56 a. m.
 */
public class UtilityItem {

    /**
     * The type of product consumed, expressed as text.
     */
    private String consumptionType;
    /**
     * The type of product consumed, expressed as a code.
     */
    private String consumptionTypeCode;
    /**
     * Information of the actual payments type for the utility Item
     */
    private String currentChargeType;
    /**
     * Information of the actual payments type code expressed as a code
     */
    private String currentChargeTypeCode;
    /**
     * Text describing the consumption product.
     */
    private String description;
    /**
     * An identifier for this utility item.
     */
    private String id;
    /**
     * Information about the one-time payment type in case everything is paid
     * One time
     */
    private String oneTimeChargeType;
    /**
     * Information about the one-time payment type code
     */
    private String oneTimeChargeTypeCode;
    /**
     * The unit packaging quantity.
     */
    private BigDecimal packQuantity;
    /**
     * The number of items in a pack.
     */
    private BigDecimal packSizeNumeric;
    /**
     * An identifier for the subscriber to the utility.
     */
    private String subscriberID;
    /**
     * Identification of the subscriber type, expressed as text..
     */
    private String subscriberType;
    /**
     * The code identifying for the service type.
     */
    private String subscriberTypeCode;
    private List<Contract> contracts = new ArrayList<>();
    private List<TaxCategory> taxCategories = new ArrayList<>();

    /**
     * @return the consumptionType
     */
    public String getConsumptionType() {
        return consumptionType;
    }

    /**
     * @param consumptionType
     *            the consumptionType to set
     */
    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType;
    }

    /**
     * @return the consumptionTypeCode
     */
    public String getConsumptionTypeCode() {
        return consumptionTypeCode;
    }

    /**
     * @param consumptionTypeCode
     *            the consumptionTypeCode to set
     */
    public void setConsumptionTypeCode(String consumptionTypeCode) {
        this.consumptionTypeCode = consumptionTypeCode;
    }

    /**
     * @return the currentChargeType
     */
    public String getCurrentChargeType() {
        return currentChargeType;
    }

    /**
     * @param currentChargeType
     *            the currentChargeType to set
     */
    public void setCurrentChargeType(String currentChargeType) {
        this.currentChargeType = currentChargeType;
    }

    /**
     * @return the currentChargeTypeCode
     */
    public String getCurrentChargeTypeCode() {
        return currentChargeTypeCode;
    }

    /**
     * @param currentChargeTypeCode
     *            the currentChargeTypeCode to set
     */
    public void setCurrentChargeTypeCode(String currentChargeTypeCode) {
        this.currentChargeTypeCode = currentChargeTypeCode;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the oneTimeChargeType
     */
    public String getOneTimeChargeType() {
        return oneTimeChargeType;
    }

    /**
     * @param oneTimeChargeType
     *            the oneTimeChargeType to set
     */
    public void setOneTimeChargeType(String oneTimeChargeType) {
        this.oneTimeChargeType = oneTimeChargeType;
    }

    /**
     * @return the oneTimeChargeTypeCode
     */
    public String getOneTimeChargeTypeCode() {
        return oneTimeChargeTypeCode;
    }

    /**
     * @param oneTimeChargeTypeCode
     *            the oneTimeChargeTypeCode to set
     */
    public void setOneTimeChargeTypeCode(String oneTimeChargeTypeCode) {
        this.oneTimeChargeTypeCode = oneTimeChargeTypeCode;
    }

    /**
     * @return the packQuantity
     */
    public BigDecimal getPackQuantity() {
        return packQuantity;
    }

    /**
     * @param packQuantity
     *            the packQuantity to set
     */
    public void setPackQuantity(BigDecimal packQuantity) {
        this.packQuantity = packQuantity;
    }

    /**
     * @return the packSizeNumeric
     */
    public BigDecimal getPackSizeNumeric() {
        return packSizeNumeric;
    }

    /**
     * @param packSizeNumeric
     *            the packSizeNumeric to set
     */
    public void setPackSizeNumeric(BigDecimal packSizeNumeric) {
        this.packSizeNumeric = packSizeNumeric;
    }

    /**
     * @return the subscriberID
     */
    public String getSubscriberID() {
        return subscriberID;
    }

    /**
     * @param subscriberID
     *            the subscriberID to set
     */
    public void setSubscriberID(String subscriberID) {
        this.subscriberID = subscriberID;
    }

    /**
     * @return the subscriberType
     */
    public String getSubscriberType() {
        return subscriberType;
    }

    /**
     * @param subscriberType
     *            the subscriberType to set
     */
    public void setSubscriberType(String subscriberType) {
        this.subscriberType = subscriberType;
    }

    /**
     * @return the subscriberTypeCode
     */
    public String getSubscriberTypeCode() {
        return subscriberTypeCode;
    }

    /**
     * @param subscriberTypeCode
     *            the subscriberTypeCode to set
     */
    public void setSubscriberTypeCode(String subscriberTypeCode) {
        this.subscriberTypeCode = subscriberTypeCode;
    }

    /**
     * @return the contracts
     */
    public List<Contract> getContracts() {
        return contracts;
    }

    /**
     * @param contracts
     *            the contracts to set
     */
    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    /**
     * @return the taxCategories
     */
    public List<TaxCategory> getTaxCategories() {
        return taxCategories;
    }

    /**
     * @param taxCategories
     *            the taxCategories to set
     */
    public void setTaxCategories(List<TaxCategory> taxCategories) {
        this.taxCategories = taxCategories;
    }

}// end Utility Item